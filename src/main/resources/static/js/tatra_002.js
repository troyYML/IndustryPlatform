var tatra = window.tatra = window.tatra || {}

tatra.Carousel = function (element, options){
	
	this.$element = $(element);
	this.options = $.extend({
		item: 'li', // elementy ktere se budou scrollovat
		start: 1, // element kterým se začíná
		scroll: 1, // počet scrollovaných elementů v jednom kroce
		visible: 4, // počet viditelných elementů
		animation: 150, // čas za který se provede animace kroku
		boxClass: 'carousel-box', 
		spcClass: 'carousel-spc',
		clipClass: 'carousel-clip',
		htmlPrev: '<a href="#">prev</a>',
		htmlNext: '<a href="#">next</a>',
		repeat: true		
	}, options)
	this.$items = this.$element.find(this.options.item);
	this.length = this.$items.length;
	this.current = this.options.start - 1;
	this.past = this.current; 
	this.scroll = this.options.scroll;
	this.visible = this.options.visible;
	this.end = this.length - this.visible;
	this.isRepeat = this.options.repeat;

};

tatra.Carousel.prototype = {
	
	constructor: tatra	.Carousel,
	
	// reference na jquery proxy
	proxy : $.proxy,
	
	// reference na globální objekt Math
	abs: Math.abs,
		
	init: function() {
		if(this.$element.data('carouselInit') || !this.$element.length)
		{
			return this;
		}
		
		var o = this.options,
			e = this.$element;
		
		// vypočítání pozic elementů - nemusí se pořád dokola zjišťovat
		this.offsets = [];
		for (var i=0, l=this.length; i < l; i++) {
			this.offsets[i] = this.$items.get(i).offsetLeft;
		};
	
		e
			.css({'overflow':'visible', 'position':'relative', 'left': -this.offsets[this.current]+'px'})
			.wrap('<div class="'+ o.boxClass +'"><div class="'+ o.spcClass +'"><div class="'+ o.clipClass +'"></div></div></div>')
			.width(e.attr('scrollWidth'))
			.scrollLeft(0)
			.data('carouselInit', true);
			
		this.$box = e.closest('.' + o.boxClass);
		this.$spc = e.closest('.' + o.spcClass);
		this.$clip = e.closest('.' + o.clipClass);
		
		if(o.htmlPrev && this.end > 0){
			this.$prev = $(o.htmlPrev);
			this.$prev
				.addClass('prev')
				.appendTo(this.$spc)
				.bind('click.carousel', this.proxy(this.prev, this));
			
			if (!this.isRepeat){
				this.controlPrev();
			}
		}
		if(o.htmlNext && this.end > 0){
			this.$next = $(o.htmlNext);
			this.$next
				.addClass('next')
				.appendTo(this.$spc)
				.bind('click.carousel', this.proxy(this.next, this));
			
			if (!this.isRepeat){
				this.controlNext();
			}		
		}
		
		return this;
	},
	// metoda pro zjištění zda je daný element plně vidět ve výřezu
	isVisible: function(i){
		var cW = this.$clip.width(),
			cOff = this.offsets[this.current],
			iW = this.$items.eq(i).outerWidth(),
			iOff = this.offsets[i];	
		
		return (cOff <= iOff && (cW+cOff) >= (iW + iOff));
	},
	next: function() {
		var i = this.end;
		
		if(this.current != this.end){
			var i = this.current + this.scroll;
			i = i > this.end ? this.end : i;	
		}
		else if (this.isRepeat){
			var i = 0;
		}
		
		this.scrollTo(i, true);
		return false;
	},
	prev: function() {
		var i = 0;
		
		if(this.current != 0){
			i = this.current - this.scroll;	
			i = i < 0 ? 0 : i;
		}
		else if (this.isRepeat){
			i = this.end;
		}

		this.scrollTo(i, true);
		return false;	
	},
	scrollTo: function(i, inner) {	

		this.past = this.current;
		if(!inner){
			i = i < 0 ? 0 : i;	
			i = i > this.end ? this.end : i;
		}	
		this.current  =  i;
		// získání rozdílu mezi indexama - 3členkou pak vypočítám stejnou rychlost pro scrollování menšího počtu elementů
		var diff = this.abs( i - this.past )
		if(diff){
			this.$element.stop().animate({
				'left': -this.offsets[i]
			}, this.options.animation / this.scroll * diff, 'swing');
			
			if (!this.isRepeat){
				this.controlPrev();
				this.controlNext();
			}
		}
	},
	controlPrev: function() {
		this.$prev[(this.current == 0) ? 'addClass' : 'removeClass']('prev-disable');
	},
	controlNext: function() {
		this.$next[(this.current == this.end) ? 'addClass' : 'removeClass']('next-disable');
	}
	
};


tatra.HistoryCarousel = function (element, options)
{
	this.$element = $(element);
	this.options = $.extend({
		htmlPrev: '<a href="#">prev</a>',
		htmlNext: '<a href="#">next</a>',
		repeat: true		
	}, options)
};

tatra.HistoryCarousel.prototype.init = function()
{
	
	this.$element.wrap('<div class="carousel-spc"><div class="carousel-clip"></div></div>')
	this.$spc = this.$element.closest('.carousel-spc');
	if(this.options.htmlPrev){
		this.$prev = $(this.options.htmlPrev);
		this.$prev
			.addClass('prev')
			.appendTo(this.$spc);
	}
	if(this.options.htmlNext){
		this.$next = $(this.options.htmlNext);
		this.$next
			.addClass('next')
			.appendTo(this.$spc);
	}
	
	this.$scrollBox = this.$element.closest('.carousel-clip');
	this.$ul =  this.$element.css({ position: 'relative' });
	var ulWidth = 0;
	this.$ul.find('li').each(function(){ ulWidth += $(this).outerWidth(); });
	this.ulWidth = ulWidth;
	this.scrollBoxWidth = this.$scrollBox.width();
	
	this.position = 0;
	this.step = 10;
	
	this.$prev.bind('click', function(){ return false; });	
	this.$next.bind('click', function(){ return false; });

	this.$prev.bind('mouseenter', $.proxy(this.prev, this));	
	this.$next.bind('mouseenter', $.proxy(this.next, this));
	this.$prev.bind('mouseleave', $.proxy(this.leave, this));	
	this.$next.bind('mouseleave', $.proxy(this.leave, this));
};

tatra.HistoryCarousel.prototype.prev = function(event)
{
	this.animationSign = 1;
	this.stopped = false;
	this.animate();
};

tatra.HistoryCarousel.prototype.next = function(event)
{
	this.animationSign = -1;
	this.stopped = false;
	this.animate();
};

tatra.HistoryCarousel.prototype.leave = function(event)
{
	this.stopped = true;	
};
tatra.HistoryCarousel.prototype.animate = function()
{
	if(!this.stopped)
	{
		this.position += this.animationSign * this.step;
		
		if(this.position > 0) this.position = 0;
		if(this.position < this.scrollBoxWidth - this.ulWidth) this.position = this.scrollBoxWidth - this.ulWidth;
		this.$ul.css({ left:  this.position });
		this.timer = setTimeout($.proxy(this.animate, this), 20);
	}
};

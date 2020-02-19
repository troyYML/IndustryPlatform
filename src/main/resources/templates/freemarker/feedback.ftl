
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ie6ie7 oldie"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ie6ie7 oldie"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8 oldie"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="js wf-myriadpro-n4-active wf-myriadpro-n6-active wf-myriadpro-n7-active wf-active" lang="en"><!--<![endif]--><head>
    <#include "common/head.ftl">
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
    <link rel="stylesheet" href="${ctx}/static/css/alert.css">
    <script src="${ctx}/static/js/alert.min.js"></script>
</head>
<body class="page-subpage">
<p id="nav-skip">
    <a title="Go to content (Hot key: Alt + 2)" accesskey="2" href="#main">Go to content</a>
    <span class="hidden">|</span>
    <a href="#main-menu">Go to main menu</a>
</p>
<div id="wrap">
    <div id="header" style="background-image: url(images/poz-spolecnost.jpg)">
        <div id="header-wrap">
            <div class="row row-main">
                <h1 id="logo-box">
                    <span id="logo"><img src="static/img/logo" height="110" width="110"></span>
                    <span id="claim">${factoryName!}</span>
                </h1>
            </div>
        </div>
    </div>
    <hr class="hidden">
    <div id="main-menu" class="row row-main">
        <ul class="reset">


            <li id="menu-01" class="first" style="width: 196px"><a href="index">首 页</a></li>

            <li id="menu-02" style="width: 196px"><a href="about">公司简介</a></li>

            <li class="" id="menu-03" style="width: 196px"><a href="news">公司新闻</a></li>

            <li class="" id="menu-04" style="width: 196px"><a href="products">产品中心</a></li>

            <li id="menu-07" class="last" style="width: 196px"><strong class="active">联络我们</strong></li>

        </ul>
    </div>



    <div id="main" class="row row-main">
        <div class="row">
            <div class="content-box content-box-dealers">
                <div class="row">
                    <div class="col col-full">
                        <p id="breadcrumb"><a href="index">首页</a> <strong>联络我们</strong></p>
                        <h1>联系方式</h1>
                        <div class="table-wrap"><table>
                            <colgroup> <col width="290"> </colgroup> <thead>
                        <tr>
                            <th width="31%" class="first" style="padding-left: 27px;">How to reach us?</th>
                            <th width="69%" class="last" style="padding-left: 27px;">Map</th>
                        </tr>
                        </thead>
                            <tbody>
                            <tr>
                                <td class="contact-phones first">
                                    <div>
                                        <p class="larger red"><strong>${factoryName!}</strong></p>
                                        <p>地址：${address!}</p>
                                        <p>电话：${contractPhone!}</p>
                                        <p>传真：${contractFax!}</p>
                                        <p>电邮：${contractMail!}</p>
                                        <p>网址：${website!}</p>
                                    </div></td>
                                <td class="last" style="padding: 27px;">

                                    <div style="width:590px;height:200px;border:#ccc solid 1px;" id="dituContent"></div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                            <span class="cor cor-tl"></span><span class="cor cor-tr"></span><span class="cor cor-bl"></span><span class="cor cor-br"></span></div>
                        <div>
                                <div class="table-wrap"><table>
                                    <colgroup>
                                        <col width="290">
                                        <col width="290">
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th class="first" style="padding-left: 27px;">联系电话</th>
                                        <th class="last" style="padding-left: 20px;" colspan="2">在线反馈</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td class="contact-phones first"><div>
                                            <p><span class="fl">${contractWay1!}
</span></p>
                                            <p><span class="fl">${contractWay2!}
</span></p>
                                            <p><span class="fl">${contractWay3!}
</span></p>

                                        </div></td>
                                        <td>
                                            <div>

                                                <p><label class="inp-fix"><strong>您的姓名: *</strong><br>
                                                    <input name="name" class="inp-text w-full" type="text"></label>
                                                </p>
                                                <p><label class="inp-fix"><strong>您的电邮: *</strong><br>
                                                    <input <input name="email" class="inp-text w-full" type="text"></label>
                                                </p>
                                                <p><label class="inp-fix"><strong>您的电话: *</strong><br>
                                                    <input <input name="phone" class="inp-text w-full" type="text"></label>
                                                </p>

                                            </div>
                                        </td>
                                        <td class="last">
                                            <div>
                                                <p><label class="inp-fix"><strong>具体内容: *</strong><br>
                                                    <textarea name="content" cols="50" rows="15" class="inp-text w-full count"></textarea></label>
                                                </p>
                                                <div class="fl">

                                                </div>
                                                <div class="fr"><input name="Submit" value="contactSend" type="hidden"> <span class="inline-btn"><input value="Send" class="btn-submit" type="submit" id="submit"></span></div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                    <span class="cor cor-tl"></span><span class="cor cor-tr"></span><span class="cor cor-bl"></span><span class="cor cor-br"></span></div>

                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="row foot-crossroad">
            <h2 class="out">Rozcestník kategorií</h2>
        </div>			</div>
    <hr class="hidden">

</div>

<#include "common/searchBox.ftl">

<div id="head-links" class="reset">
    <div style="" class="wrap">
        <div class="box">


        </div>
    </div>
    <#include "common/language.ftl">
</div>

<div id="dialog" title="Basic dialog">
    <p id="message"></p>
</div>
<#include "common/foot.ftl">

<script type="text/javascript">

    createMap();//创建地图
    setMapEvent();//设置地图事件
    var M = {

    }


    //创建地图函数：

    function createMap(){

        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图

        var point = new BMap.Point(104.081592,30.655831);//定义一个中心点坐标

        map.centerAndZoom(point,12);//设定地图的中心点和坐标并将地图显示在地图容器中

        window.map = map;//将map变量存储在全局

    }



    //地图事件设置函数：

    function setMapEvent(){

        map.disableDragging();//启用地图拖拽事件，默认启用(可不写)

        map.disableScrollWheelZoom();//启用地图滚轮放大缩小

        map.disableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)

        map.disableKeyboard();//启用键盘上下左右键移动地图

    }




    $("#submit").bind("click",function () {
        var name = $("[name=name]").val();
        var email = $("[name=email]").val();
        var phone = $("[name=phone]").val();
        var content = $("[name=content]").val();
        if(name == ''){
            showDialog("请输入姓名！");
            return false;
        }
        if(email == '' && phone == ''){
            showDialog("邮箱和电话不能都为空！");
            return false;
        }
        if (email != '') {
            var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            if(!reg.test(email)){
                showDialog("邮箱格式不正确!");
                return false;
            }
        }
        if (phone != '') {
            var telRxg = /^0\d{2,3}-?\d{7,8}$/;
            var phoneRxg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if(!telRxg.test(phone) && !phoneRxg.test(phone)){
                showDialog("电话格式不正确!");
                return false;
            }
        }
        if(content == ''){
            showDialog("请输入咨询内容！");
            return false;
        }
        var data = {
            "name": name,
            "email": email,
            "phone": phone,
            "content": content
        };
        $.ajax({
            url: "onlineContract",
            type: "post",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (res) {
                var date;
                if(res!=''){
                    showDialog(res.msg);
                }else{
                    showDialog("提交失败，请稍后重试!");
                }
            },
            error:function(e){
                showDialog("错误！！");
            }
        });
        return false;
    })

    function showDialog(msg){
        M.dialog1 = jqueryAlert({
            'content' : msg,
            'closeTime' : 2000,
            'end':function(){
                console.log('已关闭弹框')
            }
        })
    }

</script>

</body></html>
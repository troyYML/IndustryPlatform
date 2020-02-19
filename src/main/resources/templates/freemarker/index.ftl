

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ie6ie7 oldie"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ie6ie7 oldie"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8 oldie"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="js wf-myriadpro-n4-active wf-myriadpro-n6-active wf-myriadpro-n7-active wf-active" lang="en"><!--<![endif]--><head>
    <#include "common/head.ftl">
</head>

<body class="page-homepage">
<p id="nav-skip">
    <a title="Go to content (Hot key: Alt + 2)" accesskey="2" href="#main">Go to content</a>
    <span class="hidden">|</span>
    <a href="#main-menu">Go to main menu</a>
</p>
<div id="wrap">
    <div id="header">

        <div class="slides">all111.png
            <div id="header-slide02" class="slide" style="background-image: url(static/img/home-motive-1.jpg); display: block; opacity: 1;"></div>
        </div>

        <div id="header-wrap">
            <div class="row row-main">
                <h1 id="logo-box">
                    <span id="logo"><img src="static/img/logo.png" height="110" width="110"></span>
                    <span id="claim">${factoryName!}</span>
                </h1>
            </div>
        </div>
    </div>
    <hr class="hidden">
    <div id="main-menu" class="row row-main">
        <ul class="reset">

            <li id="menu-01" class="first" style="width: 196px"><strong class="active">首 页</strong></li>

            <li id="menu-02" style="width: 196px"><a href="${ctx}/about">公司简介</a></li>

            <li class="" id="menu-03" style="width: 196px"><a href="${ctx}/news">公司新闻</a></li>

            <li class="" id="menu-04" style="width: 196px"><a href="${ctx}/products">产品中心</a></li>

            <li id="menu-07" class="last" style="width: 196px"><a href="${ctx}/feedback">联络我们</a></li>

        </ul>
    </div>



    <div id="intro" class="row row-main">
        <div class="slide" id="intro-slide01">
            ${introduce.content!}  </div>


        <p style="opacity: 1;" class="pager"><a class="active" href="#">1</a><a class="" href="#">2</a><a class="" href="#">3</a><a class="" href="#">4</a><a class="" href="#">5</a></p>
    </div>



    <div id="main" class="row row-main">
        <div class="row">
            <div class="main-box home-crossroad">
                <div class="main-hd">
                    <h2>产品展示</h2>
                    <h2 class="hidden">更多产品</h2>
                    <p>
                        <a href="${ctx}/products?page=1" class="more2">了解更多产品</a>

                    </p>
                </div>


                <td valign="top">



                    <div class="main-bd main-bd-s row">
                        <div class="col col-full">
                            <div class="img-crossroad">
                                <ul class="reset">


                                    <#if productList??>
                                    <#list productList as product>

                                        <li class="first">
                                            <a href="${ctx}/productDetail?id=${product.id}" class="item">
                                                <span class="img">
                                                    <img src="<#if product.pic?? && product.pic!=''>/profile/avatar/${product.pic}<#else>${ctx}/static/img/profile.jpg</#if>" width="130" height="130" border="0">
                                                </span>

                                                <span class="name">${product.name}</span>
                                            </a>
                                        </li>
                                        </#list>
                                        </#if>


                                    <li class="last">

                                    </li>
                                </ul>

                                <ul class="reset hidden">
                                    <li class="first">
                                    </li>
                                    <li class="last">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
        <div class="row">
            <div class="main-box main-box-news">
                <div class="main-hd">
                    <h2>公司介绍</h2>
                    <p>
                        <a href="${ctx}/about" class="more2">了解更多</a>
                    </p>
                </div>
                <div class="main-bd row">
                    <div class="col col-home-a">
                        <div >

                            <table width="100%" border="0">
                                <tr>
                                    <td width="9%">&nbsp;</td>
                                    <td width="83%">${articleIntroduce.content!}
                                        &nbsp;</td>
                                    <td width="8%">&nbsp;</td>
                                </tr>
                            </table>

                        </div>
                    </div>
                    <div class="col col-home-b">



                        <div class="hp-purchase">
                            <h2>在线联系</h2>
                            <div class="row">
                                <img src="static/img/qq1.png"><br /><br />
                                <h3>QQ :${contractQQ!}</h3>
                                <p>在产品、服务、配送机制或其他工作中的任何问题，我们将有专人响应您的建意和需求...</p>
                            </div>
                            <p class="more"><a href="${ctx}/feedback">在线留言</a>
                            </p></div>
                        <form class="newsletter-box">
                            <fieldset class="spc">
                                <h3>联系方式</h3>
                                <p>电话：${contractPhone!}</p>
                                <p>传真：${contractFax!}</p>
                                <p>电邮：${contractMail!}</p>
                            </fieldset>
                        </form>	</div>
                </div>
            </div>
        </div>

        <div class="row foot-crossroad">



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


<#include "common/foot.ftl">

</body></html>


<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ie6ie7 oldie"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ie6ie7 oldie"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8 oldie"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="js wf-myriadpro-n4-active wf-myriadpro-n6-active wf-myriadpro-n7-active wf-active" lang="en"><!--<![endif]--><head>
    <#include "common/head.ftl">

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
                    <span id="logo"><img src="static/img/logo.png" height="110" width="110"></span>
                    <span id="claim">${factoryName!}</span>
                </h1>
            </div>
        </div>
    </div>
    <hr class="hidden">
    <div id="main-menu" class="row row-main">
        <ul class="reset">


            <li id="menu-01" class="first" style="width: 196px"><a href="index">首 页</a></li>

            <li id="menu-02" style="width: 196px"><strong class="active">公司简介</strong></li>

            <li class="" id="menu-03" style="width: 196px"><a href="news">公司新闻</a></li>

            <li class="" id="menu-04" style="width: 196px"><a href="products">产品中心</a></li>

            <li id="menu-07" class="last" style="width: 196px"><a href="feedback">联络我们</a></li>

        </ul>

    </div>
    <div id="main" class="row row-main">
        <div class="row">
            <div class="content-box content-box-2cols">
                <div class="row">
                    <div class="col col-content">
                        <p id="breadcrumb"><a href="index">首页</a> <a href="about">关于昌业</a> 公司简介 </p>
                        <h1>${factoryName!}</h1>

                        <div class="row share-line">
                            <div class="fl">

                            </div>
                            <div class="fr">

                                <a href="#" class="print">Print</a>
                            </div>
                        </div>

                        <table width="100%" border="0">
                            <tr>
                                <td width="8%">&nbsp;</td>
                                <td width="89%"><br />
                                    ${article.content!}
                                <td width="3%">&nbsp;</td>
                            </tr>
                        </table>
                    </div>

                    <div class="col col-side"><div class="side-box side-menu">
                        <div class="spc"><h2>产品目录</h2>
                            <ul class="reset">

                                <li>
                                    <#if menuList??>
                                    <#list menuList as menu>
                                        <li>   <a href="${ctx}/products<#if menu.menuId??>?menuId=${menu.menuId?c}</#if>"><font color=#0e6f8f>${menu.menuName}</font></a><li>
                                    </#list>
                                    </#if>
                            </li>

                            </ul>
                        </div></div>


                        <form action="searchSelect" method="post" class="side-box side-newsletter">
                            <fieldset class="spc">
                                <h2 class="title">产品搜索</h2>
                                <p class="desc">您可输入您需要的产品名称或编号查询...</p>
                                <p class="form"><span class="form-one-row"><input class="inp-text" name="form-q" type="text">
          <span class="inline-btn btn-gray-red"><input value="Search" type="submit"></span></span></p>
                                <p class="link"></p>
                            </fieldset>
                        </form></div>						</div>
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
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                template="../../../resources/templates/template.xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets" >
    <ui:define name="navigaion_content">  
       
        <!-- search form -->
        <li class="header">MAIN NAVIGATION</li>    
        <li class="treeview">       
            <a href="../../HomePage.xhtml"><i class="fa fa-circle-o-notch"></i> Home </a>
        </li>
        <li class="treeview">
            <a href="#treeview-menu">
                <i class="fa fa-files-o"></i>
                <span>Employee Profile</span>
            </a>
            <ul class="treeview-menu">
                <li>
                    <a href="employee/employee.xhtml"><i class="fa fa-fw"></i> Employee</a>
                </li>
            </ul>
        </li>
        <li class="treeview">
            <a href="#treeview-menu">
                <i class="fa fa-files-o"></i>
                <span>Subject Registration</span>
            </a>
            <ul class="treeview-menu">
                <li>
                    <a href="subject/subject.xhtml"><i class="fa fa-fw"></i> Subject</a>
                </li>
            </ul>
        </li>
        <li class="treeview">
            <a href="#treeview-menu">
                <i class="fa fa-files-o"></i>
                <span>Student Registration</span>
            </a>
            <ul class="treeview-menu">
                <li>
                    <a href="employee/student/student.xhtml"><i class="fa fa-fw"></i> Student</a>
                </li>
            </ul>
        </li>
<li class="treeview">
            <a href="#treeview-menu">
                <i class="fa fa-files-o"></i>
                <span>Fill Mark</span>
            </a>
            <ul class="treeview-menu">
                <li>
                    <a href="Mark/Mark.xhtml"><i class="fa fa-fw">Mark</i></a>
                  
                </li>
            </ul>
        </li>
        <li class="treeview">
            <a href="#treeview-menu">
                <i class="fa fa-lock"></i>
                <span>Admin</span>
            </a>
            <ul class="treeview-menu">
                <li><a href="address/address.xhtml"><i class="fa fa-fw"></i>Address</a></li>
                <li><a href="../commonApplication/lookUpManager.xhtml"><i class="fa fa-fw"></i>Lookup</a></li>  
                <li><a href="../commonApplication/report.xhtml"><i class="fa fa-book"></i> <span>Report</span></a></li>
            </ul>
        </li> 
    </ui:define>

    <ui:define name="contents">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">26</div>
                                    <div>Total Employee</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>New Tasks!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">124</div>
                                    <div>Employee On Leave</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">13</div>
                                    <div>Terminated Employee</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="col-md-12">
                <div class="box box-solid">
                    <div class="box-header with-border">
                        <h3 class="box-title">Ethiopian Electric Power Corporation ERP</h3>
                    </div><!-- /.box-header -->
                    <div class="box-body">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                                <li data-target="#carousel-example-generic" data-slide-to="3" class=""></li>
                                <li data-target="#carousel-example-generic" data-slide-to="4" class=""></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="../../resources/eepSlide/eepcoImage1.jpg" alt=""/>                                    
                                    <div class="carousel-caption">
                                        First Slide
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="../../resources/eepSlide/eepcoImage2.jpg" alt=""/>
                                    <div class="carousel-caption">
                                        Second Slide
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="../../resources/eepSlide/eepcoImage3.jpg" alt=""/>
                                    <div class="carousel-caption">
                                        Third Slide
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="../../resources/eepSlide/eepcoImage4.jpg" alt=""/>
                                    <div class="carousel-caption">
                                        Third Slide
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="../../resources/eepSlide/eepcoImage5.jpg" alt=""/>
                                    <div class="carousel-caption">
                                        Third Slide
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="../../resources/eepSlide/eepcoImage6.jpg" alt=""/>
                                    <div class="carousel-caption">
                                        Third Slide
                                    </div>
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="fa fa-angle-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="fa fa-angle-right"></span>
                            </a>
                        </div>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div><!-- /.col -->
            <!-- /.row -->
        </div>
    </ui:define>
</ui:composition>

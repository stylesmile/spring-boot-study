<!DOCTYPE html>
<html>
<head>
    <title>模型管理</title>
    <link href="${base}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${base}/css/animate.css" rel="stylesheet">
    <script>
        var url = "${url}";
    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">

                <div id="exampleToolbar" role="group">
                    <label style="margin-left: 10px;">
                        <button type="button" class="btn  btn-danger" onclick="batch_remove()">
                            <i class="fa fa-trash" aria-hidden="true"></i>删除
                        </button>
                    </label>

                </div>

                <table id="exampleTable" data-mobile-responsive="true">
                </table>

            </div>
        </div>
    </div>
</div>

<script src="${rc.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${rc.contextPath}/js/plugins/layer/layer.min.js"></script>
<!-- Bootstrap table -->
<script src="${base}/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${base}/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${base}/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${base}/js/slife/datatable.js"></script>
<script src="${base}/model/process/processDefinition.js"/>
</body>
</html>
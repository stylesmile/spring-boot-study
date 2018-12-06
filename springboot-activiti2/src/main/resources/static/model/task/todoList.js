function getcolumns() {
    var c = [
        {
            checkbox: true
        },
        {
            field: 'category',
            title: '流程分类'
        },
        {
            field: 'applicant',
            title: '申请人'
        },
        {
            field: 'taskName',
            title: '任务名称'
        },
        {
            field: 'title',
            title: '流程主题'
        },
        {
            field: 'xmlName',
            title: '流程XML',
            align: 'center',
            formatter: function (value, row, index) {
                var procDefId = row.processonDefinitionId;
                return '<a href=${url}resource?procDefId=' + procDefId + '&resType=xml>' + value + '</a>';
            }
        },
        {
            field: 'picName',
            title: '流程图片',
            align: 'center',
            formatter: function (value, row, index) {
                var procDefId = row.processonDefinitionId;
                return '<a href=${url}resource?procDefId=' + procDefId + '&resType=image>' + value + '</a>';
            }
        },
        {
            field: 'deploymentTime',
            title: '部署时间'
        },
        {
            title: '操作',
            field: 'id',
            align: 'center',
            formatter: function (value, row, index) {
                return dt_delete_button(row)+dt_active_button(row);
            }
        }];
    return c;
}

load_data_list(getcolumns(), {"revision": "desc"}, 'list')

function dt_delete_button(row) {
    var deleteO = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" ' +
        'onclick="remove(\'' + row.id + '\')">删除</a> ';

    return deleteO;

}

function dt_active_button(row) {
    var value = '';
    var status = '';
    if (row.suspend === false) {
        value = '挂起';
        status = 'suspend';
    } else {
        value = '激活'
        status = 'active';
    }
    var procDefId = row.processonDefinitionId;
    var deleteO = '<a class="btn btn-warning btn-sm" href="#" ' +
        'title="挂起/激活"  mce_href="#" onclick="active(\'' + procDefId + '\', \'' + status + '\')"> ' + value + ' </a> ';
    return deleteO;
}

function active(procDefId, state) {
    $.ajax({
        url: url + "status",
        type: "POST",
        data: {
            'procDefId': procDefId,
            'status': state
        },
        success: function (r) {
            dataTable_rep_message(r)
        }
    });
}
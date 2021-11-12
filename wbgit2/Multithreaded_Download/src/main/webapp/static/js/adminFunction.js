//查询单个，获取查询的id用
function selectoneinputvalue() {
    var down_id=document.getElementById("selectonedown_id").value;
    var href = "admin/selectone/" + down_id;
    window.location.replace(href);
}
//删除单个，获取删除的id后动态修改from表单action属性
function deleteoneinputvalue() {
    var down_id=document.getElementById("deleteonedown_id").value;
    document.deleteone.action = "admin/delete/" + down_id;
}

//修改单个，获取修改的id后动态修改from表单action属性
function updateoneinputvalue() {
    var down_id=document.getElementById("updateonedown_id").value;
    document.updateone.action = "admin/update/" + down_id;
}
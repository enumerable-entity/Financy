let id_to_delete = null;
let id_trans_to_edit = null;
let id_cat_to_edit = null;


function prepare_id_to_delete (id){
    id_to_delete = id;
}
function delete_tr (){
    document.getElementById("deleteButton")
        .setAttribute("href", document
            .getElementById("deleteButton")
            .getAttribute("href") + id_to_delete)
}

function prepare_id_edit_tr (id){
    id_trans_to_edit = id;
    const editForm = document.forms['editForm'];
    var date = moment(document.getElementById(id).children[0].innerHTML, "DD/MM/YYYY").add(1, 'days'); // Date bug - showed as one day back

    editForm.elements["title"].value = document.getElementById(id).children[1].innerHTML;
    document.getElementById('date').valueAsDate = new Date(date.toDate());
    editForm.elements["amount"].value = document.getElementById(id).children[2].innerHTML;
    editForm.elements["type"].value = document.getElementById(id).children[3].innerHTML;
    editForm.elements["category"].value = document.getElementById(id).children[4].className;
}
function edit_tr (){
    document.getElementById("editForm")
        .setAttribute("action", document
            .getElementById("editForm")
            .getAttribute("action") + id_trans_to_edit)
}

function prepare_id_edit_cat (id){
    id_cat_to_edit = id;
    const editCatForm = document.forms['editCatForm'];
    editCatForm.elements["title"].value = document.getElementById(id).children[0].innerHTML;
    editCatForm.elements["type"].value = document.getElementById(id).children[1].innerHTML;
}

function edit_cat (){
    document.getElementById("editCatForm")
        .setAttribute("action", document
            .getElementById("editCatForm")
            .getAttribute("action") + id_cat_to_edit)
}

var now = new Date(),

    maxDate = now.toISOString().substring(0,10);

$('[name="date"]').prop('max', maxDate);

$("#groupSelect option[name='defSelect']").prop("selected", "selected")
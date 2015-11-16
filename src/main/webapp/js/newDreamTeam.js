function formSubmit() {
    document.getElementById("logoutForm").submit();
}

(function ($) {

    $("#sgId").val("");
    $("#pgId").val("");
    $("#sfId").val("");
    $("#pfId").val("");
    $("#cId").val("");


    $(".dugme_centri").click(function () {

        var player_id = $(this).prev()[0].children[0].children[1];
        var player_name = $(this).prev()[0].children[0].children[0];
        var txt = $(player_id).text().trim();
        var text_player_name = $(player_name).text().replace(" ", "").trim();
        console.log(text_player_name);

        var sgId = $("#sgId").val();
        var pgId = $("#pgId").val();
        var sfId = $("#sfId").val();
        var pfId = $("#pfId").val();
        var cId = $("#cId").val();

        if (sgId == txt || pgId == txt || sfId == txt || pfId == txt || cId == txt) {
            alert(text_player_name + " already added to some other position");
        } else {
            $("#cId").val(txt);
            $("#c_name").html(text_player_name);
        }




    });
    $(".pf_dugme").click(function () {

        var player_id = $(this).prev()[0].children[0].children[1];
        var txt = $(player_id).text().trim();
        var player_name = $(this).prev()[0].children[0].children[0];
        var text_player_name = $(player_name).text().replace(" ", "").trim();


        var sgId = $("#sgId").val();
        var pgId = $("#pgId").val();
        var sfId = $("#sfId").val();
        var pfId = $("#pfId").val();
        var cId = $("#cId").val();

        if (sgId == txt || pgId == txt || sfId == txt || pfId == txt || cId == txt) {
            alert(text_player_name + " already added to some other position");
        } else {
            $("#pfId").val(txt);
            $("#pf_name").html(text_player_name);
        }
    });
    $(".sf_dugme").click(function () {

        var player_id = $(this).prev()[0].children[0].children[1];
        var txt = $(player_id).text().trim();
        var player_name = $(this).prev()[0].children[0].children[0];
        var text_player_name = $(player_name).text().replace(" ", "").trim();



        var sgId = $("#sgId").val();
        var pgId = $("#pgId").val();
        var sfId = $("#sfId").val();
        var pfId = $("#pfId").val();
        var cId = $("#cId").val();

        if (sgId == txt || pgId == txt || sfId == txt || pfId == txt || cId == txt) {
            alert(text_player_name + " already added to some other position");
        } else {
            $("#sfId").val(txt);
            $("#sf_name").html(text_player_name);
        }

    });
    $(".sg_dugme").click(function () {

        var player_id = $(this).prev()[0].children[0].children[1];
        var txt = $(player_id).text().trim();


        var player_name = $(this).prev()[0].children[0].children[0];
        var text_player_name = $(player_name).text().replace(" ", "").trim();



        var sgId = $("#sgId").val();
        var pgId = $("#pgId").val();
        var sfId = $("#sfId").val();
        var pfId = $("#pfId").val();
        var cId = $("#cId").val();

        if (sgId == txt || pgId == txt || sfId == txt || pfId == txt || cId == txt) {
            alert(text_player_name + " already added to some other position");
        } else {
            $("#sgId").val(txt);
            $("#sg_name").html(text_player_name);
        }




    });

    $(".pg_dugme").click(function () {

        var player_id = $(this).prev()[0].children[0].children[1];
        var txt = $(player_id).text().trim();



        var player_name = $(this).prev()[0].children[0].children[0];
        var text_player_name = $(player_name).text().replace(" ", "").trim();


        var sgId = $("#sgId").val();
        var pgId = $("#pgId").val();
        var sfId = $("#sfId").val();
        var pfId = $("#pfId").val();
        var cId = $("#cId").val();

        if (sgId == txt || pgId == txt || sfId == txt || pfId == txt || cId == txt) {
            alert(text_player_name + " already added to some other position");
        } else {
            $("#pgId").val(txt);
            $("#pg_name").html(text_player_name);
        }


    });


    $('#btn_submit').click(function (event) {


        var sgId = $("#sgId").val();
        var pgId = $("#pgId").val();
        var sfId = $("#sfId").val();
        var pfId = $("#pfId").val();
        var cId = $("#cId").val();

        console.log(sgId);

        var canSubmit = true;

        var errorLog = "";

        if (sgId == undefined || sgId == null || sgId.trim() == "") {
            errorLog += "SG, ";

            canSubmit = false;
        }
        if (pgId == undefined || pgId == null || pgId.trim() == "") {
            errorLog += "PG, ";

            canSubmit = false;
        }
        if (sfId == undefined || sfId == null || sfId.trim() == "") {
            errorLog += "SF, ";

            canSubmit = false;
        }
        if (pfId == undefined || pfId == null || pfId.trim() == "") {
            errorLog += "PF, ";

            canSubmit = false;
        }
        if (cId == undefined || cId == null || cId.trim() == "") {
            errorLog += "C ";

            canSubmit = false;
        }

        errorLog += " missing position";

        if (!canSubmit) {
            alert(errorLog);
            event.preventDefault();
        }






    });

})(jQuery);




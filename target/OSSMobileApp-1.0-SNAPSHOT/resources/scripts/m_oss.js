function validateUID() {
    var UID = document.getElementById("txt_UID").value, Error = document.getElementById("lblStatus"), length = UID.length;
    return "" == document.getElementById("txt_UID").value || "Aadhaar Number" == document.getElementById("txt_UID").value ? (document.getElementById("lblStatus").style.color = "red", Error.style.display = "block", Error.innerHTML = "Please enter 12 Digit Aadhaar Number", document.getElementById("txt_UID").focus(), !1) : eval(length) < 12 ? (document.getElementById("lblStatus").style.color = "red", Error.style.display = "block", Error.innerHTML = "Please enter Valid 12 Digit Aadhaar Number", document.getElementById("txt_UID").value = "", document.getElementById("txt_UID").focus(), !1) : vhCheck()
}
function validateOTP() {
    return "" == document.getElementById("txtOTP").value ? (document.getElementById("lblStatus").style.display = "none", document.getElementById("lblStatus").style.color = "red", document.getElementById("lblStatus").style.display = "block", document.getElementById("lblStatus").innerHTML = "Please enter OTP", document.getElementById("txtOTP").focus(), !1) : document.getElementById("txtOTP").value.length < 6 ? (document.getElementById("lblStatus").style.display = "none", document.getElementById("lblStatus").style.color = "red", document.getElementById("lblStatus").style.display = "block", document.getElementById("lblStatus").innerHTML = "Please enter 6 Digit OTP", document.getElementById("txtOTP").focus(), !1) : void 0
}
function validatePIN() {
    var e = document.getElementById("txtPIN").value;
    return "" == document.getElementById("txtPIN").value ? (document.getElementById("lblStatus3").style.display = "none", document.getElementById("tdError3").style.display = "block", document.getElementById("tdError3").style.color = "red", document.getElementById("lblError3").style.display = "block", document.getElementById("lblError3").innerHTML = "Please enter PIN", !1) : "0" == e.substr(0, 1) ? (document.getElementById("lblStatus3").style.display = "none", document.getElementById("tdError3").style.display = "block", document.getElementById("tdError3").style.color = "red", document.getElementById("lblError3").style.display = "block", document.getElementById("lblError3").innerHTML = "PIN cannot start with 0", !1) : void 0
}
function watermarkerIn() {
    "Aadhaar Number" == document.getElementById("txt_UID").value && (document.getElementById("txt_UID").value = "")
}
function watermarkerOut() {
    "" == document.getElementById("txt_UID").value && (document.getElementById("txt_UID").value = "Aadhaar Number")
}
function validatenumerics(e, t) {
    var l = e.which ? e.which : e.keyCode, n = !0;
    return 8 != l && 16 != l && 37 != l && 39 != l && 46 != l && 118 != l && (n = l >= 48 && 57 >= l), paste(t), n
}
function vhCheck() {
    var e = document.getElementById("txt_UID").value, t = e.charAt(0);
    return "0" == t || "1" == t ? (document.getElementById("lblStatus").style.color = "red", document.getElementById("lblStatus").style.display = "block", document.getElementById("lblStatus").innerHTML = "Please enter Valid 12 Digit Aadhaar Number", document.getElementById("txt_UID").value = "", document.getElementById("txt_UID").focus(), !1) : e.verhoeffCheck() ? void 0 : (document.getElementById("lblStatus").style.color = "red", document.getElementById("lblStatus").style.display = "block", document.getElementById("lblStatus").innerHTML = "Please enter Valid 12 Digit Aadhaar Number", document.getElementById("txt_UID").value = "", document.getElementById("txt_UID").focus(), !1)
}
function paste(e) {
    setTimeout(function () {
        var t = $("#" + e.id).val(), l = t.replace(/\D/g, "");
        $("#" + e.id).val(l)
    })
}
function SendOTP() {
    return $("#pnlPINOTP").hide(), $("#status").html(""), $("#resetloder").html('<img src="../../Images/galleryImages/loader.gif" alt="Preloader" class="loader_reset" />'), $.ajax({type: "POST", url: "/WebServices/CommonServices.aspx/callAuaASAService", data: '{strSelectedUID: "' + $("#hid_UID").val() + '",strOTP_PIN :""  }', contentType: "application/json; charset=utf-8", dataType: "json", success: function (e) {
            $("#resetloder").html("");
            var t = e.d.split("~");
            "true" == t[0] ? ($("#status").html(t[1]), $("#pnlPINOTP").show("slow"), $("#pnlRestPIN").hide(), $("#txtOTP_PIN").val("").focus()) : ($("#status").html(t[1]), $("#pnlPINOTP").hide(), $("#pnlRestPIN").hide())
        }, failure: function (e) {
            $("#resetloder").html(""), $("#pnlPINOTP").hide(), $("#pnlRestPIN").hide(), alert(e.d)
        }}), !1
}
function VerifyOTP() {
    return $("#status").html(""), "" == document.getElementById("txtOTP_PIN").value ? (document.getElementById("status").innerHTML = "Please enter OTP", !1) : ($("#resetloder").html('<img src="../../Images/galleryImages/loader.gif" alt="Preloader" class="loader_reset" />'), $.ajax({type: "POST", url: "/WebServices/CommonServices.aspx/callAuaASAService", data: '{"strSelectedUID": "' + $("#hid_UID").val() + '","strOTP_PIN": "' + $("#txtOTP_PIN").val() + '" }', contentType: "application/json; charset=utf-8", dataType: "json", success: function (e) {
            $("#resetloder").html("");
            var t = e.d.split("~");
            "true" == t[0] ? ($("#pnlPINOTP").hide("slow"), $("#pnlRestPIN").show("slow"), $("#txtNewPIN").val("").focus(), $("#txtConfirmPIN").val("")) : ($("#status").html(t[1]), $("#pnlRestPIN").hide(), $("#txtOTP_PIN").val("").focus())
        }, failure: function (e) {
            $("#resetloder").html(""), alert(e.d)
        }}), !1)
}
function ResetPIN() {
    var e = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
    return $("#lblStatus").html(""), "" == document.getElementById("txtNewPIN").value ? (document.getElementById("lblStatus").innerHTML = "Please enter New Password", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtNewPIN").focus(), !1) : e.test(document.getElementById("txtNewPIN").value) ? "" == document.getElementById("txtConfirmPIN").value ? (document.getElementById("lblStatus").innerHTML = "Please enter Confirm New Password", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtConfirmPIN").focus(), !1) : $("#txtNewPIN").val() != $("#txtConfirmPIN").val() ? (document.getElementById("lblStatus").innerHTML = "New Password and Confirm Password does not match", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtNewPIN").focus(), !1) : void md5authCreate("txtNewPIN", "txtConfirmPIN") : (document.getElementById("lblStatus").innerHTML = "Password should contain minimum 8 characters atleast 1 Alphabet, 1 Number and 1 Special Character", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtNewPIN").focus(), !1)
}
function closePopup() {
    $("#myModal").modal("hide"), $("#pnlPINOTP").hide(), $("#pnlRestPIN").hide(), $("#txtOTP_PIN").val(""), $("#txtNewPIN").val(""), $("#txtConfirmPIN").val(""), $("#status").html(""), $("#resetloder").html("")
}
function ShowPopup(e) {
    $("#myModal").modal("show"), $("#txt_UserID_Forgot").val(e), $("#txtNewPIN").val(""), $("#txtConfirmPIN").val(""), $("#status").html(""), $("#resetloder").html("")
}
function resizeText(e) {
    if ("" == document.body.style.fontSize)
        document.body.style.fontSize = "1.2em", document.body.style.fontSize = parseFloat(document.body.style.fontSize) + .1 * e + "em";
    else {
        var t = parseFloat(document.body.style.fontSize, 10);
        0 == e ? document.body.style.fontSize = "1.2em" : 1.3 == t && 1 == e || 1.1 == t && -1 == e || (document.body.style.fontSize = parseFloat(document.body.style.fontSize) + .1 * e + "em")
    }
}
function md5auth(e, t) {
    var l = document.getElementById(t).value, n = calcMD5(l).toUpperCase(), o = calcMD5(e + n);
    return document.getElementById(t).value = o.toUpperCase(), !0
}
function md5authCreate(e, t) {
    var l = document.getElementById(e).value, n = document.getElementById(t).value, o = calcMD5(l), r = calcMD5(n);
    return document.getElementById(e).value = o, document.getElementById(t).value = r, !0
}
function validateUser(e, t) {
    var l = document.getElementById("lblErrorLogin");
    return "" == document.getElementById("txtUserID").value ? (l.style.display = "block", l.innerHTML = "Please enter Username", document.getElementById("txtUserID").focus(), !1) : "" == document.getElementById("txtPassword").value ? (l.style.display = "block", l.innerHTML = "Please enter Password", document.getElementById("txtPassword").focus(), !1) : parseInt(document.getElementById("hid_LoginAttempt").value) >= 3 && "" == document.getElementById("txtCapchaLogin").value ? (l.style.display = "block", l.innerHTML = "Please enter the Characters", document.getElementById("txtCapchaLogin").focus(), !1) : void md5auth(e, t)
}
function CreateUser(e, t) {
    var l = /^[A-Za-z0-9_@.]{5,30}$/, n = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
    return $("#lblStatus").html(""), "" == document.getElementById("txtUser").value ? (document.getElementById("lblStatus").innerHTML = "Please enter Username", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtUser").focus(), !1) : l.test(document.getElementById("txtUser").value) ? "" == document.getElementById("txtPass").value ? (document.getElementById("lblStatus").innerHTML = "Please enter Password", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtPass").focus(), !1) : n.test(document.getElementById("txtPass").value) ? "" == document.getElementById("txtConfirmPass").value ? (document.getElementById("lblStatus").innerHTML = "Please enter Confirm New Password", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtConfirmPass").focus(), !1) : $("#txtPass").val() != $("#txtConfirmPass").val() ? (document.getElementById("lblStatus").innerHTML = "Password and Confirm Password does not match", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtPass").focus(), !1) : void md5authCreate(e, t) : (document.getElementById("lblStatus").innerHTML = "Password should contain minimum 8 characters atleast 1 Alphabet, 1 Number and 1 Special Character", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtPass").focus(), !1) : (document.getElementById("lblStatus").innerHTML = "Username should contain between 5 to 30 characters, Alphabet Number and Special Characters(_@.) allowed", document.getElementById("lblStatus").style.color = "red", document.getElementById("txtUser").focus(), !1)
}
function forgotPassword() {
    $find("TabContainer1").set_activeTabIndex(1), $("#__tab_tblpnl1").html("Forgot Password"), $("#btnuidotp").val("Submit"), $("#hid_btnText").val("Submit")
}
function CreateUserID() {
    $find("TabContainer1").set_activeTabIndex(1), $("#__tab_tblpnl1").html("Sign Up"), $("#btnuidotp").val("Sign Up"), $("#hid_btnText").val("Create UserID")
}
function ShowCreateUser() {
    $("#txtUser").focus(), $("#imgCapcha_User").attr("src", "/CreateCapcha.aspx?" + (new Date).getTime()), $("#myModalUserID").modal("show")
}
for (var elms = document.getElementsByTagName("*"), n = elms.length, i = 0; n > i; i++)
    "pointer" == window.getComputedStyle(elms[i]).cursor && (elms[i].style.cursor = "url(~/Images/newcursor.ico)");
var Verhoeff = {d: [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 2, 3, 4, 0, 6, 7, 8, 9, 5], [2, 3, 4, 0, 1, 7, 8, 9, 5, 6], [3, 4, 0, 1, 2, 8, 9, 5, 6, 7], [4, 0, 1, 2, 3, 9, 5, 6, 7, 8], [5, 9, 8, 7, 6, 0, 4, 3, 2, 1], [6, 5, 9, 8, 7, 1, 0, 4, 3, 2], [7, 6, 5, 9, 8, 2, 1, 0, 4, 3], [8, 7, 6, 5, 9, 3, 2, 1, 0, 4], [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]], p: [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 5, 7, 6, 2, 8, 3, 0, 9, 4], [5, 8, 0, 3, 7, 9, 6, 1, 4, 2], [8, 9, 1, 6, 0, 4, 3, 5, 2, 7], [9, 4, 5, 3, 1, 2, 6, 8, 7, 0], [4, 2, 8, 6, 5, 7, 3, 9, 0, 1], [2, 7, 9, 3, 8, 0, 6, 4, 1, 5], [7, 0, 4, 6, 9, 1, 3, 2, 5, 8]], j: [0, 4, 3, 2, 1, 5, 6, 7, 8, 9], check: function (e) {
        var t = 0;
        return e.replace(/\D+/g, "").split("").reverse().join("").replace(/[\d]/g, function (e, l) {
            t = Verhoeff.d[t][Verhoeff.p[7 & l][parseInt(e, 10)]]
        }), 0 === t
    }, get: function (e) {
        var t = 0;
        return e.replace(/\D+/g, "").split("").reverse().join("").replace(/[\d]/g, function (e, l) {
            t = Verhoeff.d[t][Verhoeff.p[l + 1 & 7][parseInt(e, 10)]]
        }), Verhoeff.j[t]
    }}, Verhoeff = {d: [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 2, 3, 4, 0, 6, 7, 8, 9, 5], [2, 3, 4, 0, 1, 7, 8, 9, 5, 6], [3, 4, 0, 1, 2, 8, 9, 5, 6, 7], [4, 0, 1, 2, 3, 9, 5, 6, 7, 8], [5, 9, 8, 7, 6, 0, 4, 3, 2, 1], [6, 5, 9, 8, 7, 1, 0, 4, 3, 2], [7, 6, 5, 9, 8, 2, 1, 0, 4, 3], [8, 7, 6, 5, 9, 3, 2, 1, 0, 4], [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]], p: [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 5, 7, 6, 2, 8, 3, 0, 9, 4], [5, 8, 0, 3, 7, 9, 6, 1, 4, 2], [8, 9, 1, 6, 0, 4, 3, 5, 2, 7], [9, 4, 5, 3, 1, 2, 6, 8, 7, 0], [4, 2, 8, 6, 5, 7, 3, 9, 0, 1], [2, 7, 9, 3, 8, 0, 6, 4, 1, 5], [7, 0, 4, 6, 9, 1, 3, 2, 5, 8]], j: [0, 4, 3, 2, 1, 5, 6, 7, 8, 9], check: function (e) {
        var t = 0;
        return e.replace(/\D+/g, "").split("").reverse().join("").replace(/[\d]/g, function (e, l) {
            t = Verhoeff.d[t][Verhoeff.p[7 & l][parseInt(e, 10)]]
        }), 0 === t
    }, get: function (e) {
        var t = 0;
        return e.replace(/\D+/g, "").split("").reverse().join("").replace(/[\d]/g, function (e, l) {
            t = Verhoeff.d[t][Verhoeff.p[l + 1 & 7][parseInt(e, 10)]]
        }), Verhoeff.j[t]
    }};
String.prototype.verhoeffCheck = function () {
    var e = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 2, 3, 4, 0, 6, 7, 8, 9, 5], [2, 3, 4, 0, 1, 7, 8, 9, 5, 6], [3, 4, 0, 1, 2, 8, 9, 5, 6, 7], [4, 0, 1, 2, 3, 9, 5, 6, 7, 8], [5, 9, 8, 7, 6, 0, 4, 3, 2, 1], [6, 5, 9, 8, 7, 1, 0, 4, 3, 2], [7, 6, 5, 9, 8, 2, 1, 0, 4, 3], [8, 7, 6, 5, 9, 3, 2, 1, 0, 4], [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]], t = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 5, 7, 6, 2, 8, 3, 0, 9, 4], [5, 8, 0, 3, 7, 9, 6, 1, 4, 2], [8, 9, 1, 6, 0, 4, 3, 5, 2, 7], [9, 4, 5, 3, 1, 2, 6, 8, 7, 0], [4, 2, 8, 6, 5, 7, 3, 9, 0, 1], [2, 7, 9, 3, 8, 0, 6, 4, 1, 5], [7, 0, 4, 6, 9, 1, 3, 2, 5, 8]];
    return function () {
        var l = 0;
        return this.replace(/\D+/g, "").split("").reverse().join("").replace(/[\d]/g, function (n, o) {
            l = e[l][t[7 & o][parseInt(n, 10)]]
        }), 0 === l
    }
}(), String.prototype.verhoeffGet = function () {
    var e = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 2, 3, 4, 0, 6, 7, 8, 9, 5], [2, 3, 4, 0, 1, 7, 8, 9, 5, 6], [3, 4, 0, 1, 2, 8, 9, 5, 6, 7], [4, 0, 1, 2, 3, 9, 5, 6, 7, 8], [5, 9, 8, 7, 6, 0, 4, 3, 2, 1], [6, 5, 9, 8, 7, 1, 0, 4, 3, 2], [7, 6, 5, 9, 8, 2, 1, 0, 4, 3], [8, 7, 6, 5, 9, 3, 2, 1, 0, 4], [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]], t = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 5, 7, 6, 2, 8, 3, 0, 9, 4], [5, 8, 0, 3, 7, 9, 6, 1, 4, 2], [8, 9, 1, 6, 0, 4, 3, 5, 2, 7], [9, 4, 5, 3, 1, 2, 6, 8, 7, 0], [4, 2, 8, 6, 5, 7, 3, 9, 0, 1], [2, 7, 9, 3, 8, 0, 6, 4, 1, 5], [7, 0, 4, 6, 9, 1, 3, 2, 5, 8]], l = [0, 4, 3, 2, 1, 5, 6, 7, 8, 9];
    return function () {
        var n = 0;
        return this.replace(/\D+/g, "").split("").reverse().join("").replace(/[\d]/g, function (l, o) {
            n = e[n][t[o + 1 & 7][parseInt(l, 10)]]
        }), l[n]
    }
}(), $(function () {
    $('[data-toggle="tooltip"]').tooltip()
});
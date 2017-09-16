function checkName() {
   var nameO = document.getElementById("nameI");
   var nameV = nameO.value;
   var nameSO = document.getElementById("nameS");
    /**
     * 名字规则:
     * 可以为汉字,不可以为空
     * 用户名 2~18
     * 用户名不可以含有非法字符
     */
    var reg=/^[a-zA-Z\u4e00-\u9fa5_][0-9a-zA-Z\u4e00-\u9fa5_]{1,17}$/;
    if((1<nameV.length && nameV.length<19) && reg.test(nameV)){
        nameSO.innerHTML = "name is legal!".fontcolor("Green");
        return true;
    }else{
        nameSO.innerHTML = "Please check name!".fontcolor("Red");
        nameO.focus();
        return false;
    }
}
function checkNumber() {
    var numberO = document.getElementById("phoneNumberI");
    var numberV = numberO.value;
    var numberSO = document.getElementById("phoneNumberS");
    var reg = /^1[34578]\d{9}$/;

    if(numberV.length === 11 && reg.test(numberV)){
        numberSO.innerHTML = "phoneNumber is legal! ".fontcolor("Green");
        return true;
    }else{
        numberSO.innerHTML = "Please check phoneNumber! ".fontcolor("Red");
        return false;
    }
}
function checkEmail() {
    var emailO = document.getElementById("emailI");
    var emailV = emailO.value;
    var emailSO = document.getElementById("emailS");
    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if(0 < emailV.length && reg.test(emailV)){
        emailSO.innerHTML = "email is legal! ".fontcolor("Green");
        return true;
    }else{
        emailSO.innerHTML = "Please check email! ".fontcolor("Red");
        return false;
    }
}
function check() {
    return (checkName() && checkEmail()) && checkNumber();
}
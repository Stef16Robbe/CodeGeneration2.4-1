function SetNavBar(active){
    var navbar
    if(sessionStorage.getItem("session") == null && (active == "home" || active == "login" || active == "unset")){
        navbar = GetUnsetUserNavBar()
    }
    else{
        CheckIfUserIsLoggedIn()

        if(GetCurrentUserRole() == 'Employee'){
            navbar = GetEmployeeNavBar()
        }
        else{
            navbar = GetCustomerNavBar()
        }
    }

    //Set navbar in HTML file
    $("nav").html(navbar)
    //Set active item in navbar (BOLD)
    SetItemActive(active)
}

function GetCustomerNavBar(){
    return '\
        <ul>\
          <li><p class="group-name"> Groep 3B</p></li>\
          <li style="float:right"><a class="logout" type="button" onclick="logout()">Logout</a></li>\
          <li id="myProfile" style="float:right"><a href="ViewUser.html">My Profile</a></li>\
          <li id="myAccounts" style="float:right"><a href="MyAccounts.html">My Accounts</a></li>\
        </ul>'
}

function GetEmployeeNavBar(){
    return '\
        <ul>\
            <li><p class="group-name"> Groep 3B</p></li>\
            <li style="float:right"><a class="logout" type="button" onclick="logout()">Logout</a></li>\
            <li id="myProfile" style="float:right"><a href="ViewUser.html">My Profile</a></li>\
            <li id="dashboard" style="float:right"><a href="EmployeeDashboard.html">Dashboard</a></li>\
            <li id="myAccounts" style="float:right"><a href="MyAccounts.html">My Accounts</a></li>\
        </ul>'
}

function GetUnsetUserNavBar(){
    return '\
        <ul>\
            <li><p class="group-name"> Groep 3B</p></li>\
            <li id="login" style="float:right"><a href="Login.html">Login</a></li>\
            <li id="home"style="float:right"><a href="Home.html">Home</a></li>\
        </ul>'
}

function SetItemActive(active){
    if(document.getElementById(active)){
        document.getElementById(active).classList.add("active")
    }
}

function CheckIfUserIsLoggedIn(){
    var authKey = GetCurrentUserAuthKey()
    if(authKey == null){
        window.location.href = './Login.html';
    }
}

function GetCurrentUser(){
    var user;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/SessionToken/"+sessionStorage.getItem("session"),
        headers: {
            "session": sessionStorage.getItem("session")
        },
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: false,
        success: function(data){
            user = data
        }
    });
    return user
}

function GetCurrentUserRole(){
    return GetCurrentUser().role
}

function GetCurrentUserAuthKey(){
    return GetCurrentUser().authKey
}

function GetCurrentUserId(){
    return GetCurrentUser().userId
}

function logout() {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/Logout",
        headers: {
            "session": sessionStorage.getItem("session")
        },
        complete: function(jqXHR) {
            switch (jqXHR.status) {
                case 200:
                    alert("You have been logged out.");
                    sessionStorage.removeItem("session")
                    window.location.href = './Login.html';
                    break;
                default:
                    alert(jqXHR.responseText);
            }
        }
    });
}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

function GetDate(transaction) {
    var date = new Date(transaction.timestamp);
    var ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(date)
    var mo = new Intl.DateTimeFormat('en', { month: 'short' }).format(date)
    var da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(date)
    date = `${da} ${mo} ${ye}`
    return date;
}

function GetDateTime(timestamp){
    const date = new Date(timestamp)
    const ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(date)
    const mo = new Intl.DateTimeFormat('en', { month: 'short' }).format(date)
    const da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(date)
    return `${da} ${mo} ${ye}`
}

function SetDefaultDates(){
    var dateFrom = new Date()
    dateFrom.setDate(dateFrom.getDate() - 7)
    dateStart = document.getElementById("startdate").value = dateFrom.toISOString().substr(0, 10)
    var dateTo = new Date()
    dateEnd = document.getElementById("enddate").value = dateTo.toISOString().substr(0, 10)
}
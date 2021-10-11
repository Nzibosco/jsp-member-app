console.log("html document successfully loaded from server");
var messageTag = document.getElementById("message");
var dateTag = document.getElementById("date");
var addMemberRes = document.getElementById("response");
var memberDetails = document.getElementById("details");
var responseSection = document.getElementById("response-section");

document.getElementById("welcome-btn").addEventListener("click", function(){

    messageTag.innerText = "";
    dateTag.innerText = "";

    console.log("Button clicked!");
    fetch("http://localhost:8080/serverPages/welcome").
    then(function(res){
        return res.json();

    }).then(function(data){
        console.log(data);
        messageTag.innerText = data.message;
        dateTag.innerText = " You Joined On "+ data.todaysDate;
    });
})

document.getElementById("member").addEventListener("click", function(){
var member = {
    firstname: document.getElementById("fname").value,
    lastname: document.getElementById("lname").value,
    email: document.getElementById("email").value,
    phoneNumber: document.getElementById("phone").value,
    address: document.getElementById("address").value,
    dob: document.getElementById("dob").value
}

console.log("Member data pulled from the form:  \n " + member);
    addMemberRes.innerText = "";
    console.log("Starting to add a member");
    addMemberRes.innerText = "This button will add a new member!"

    fetch("http://localhost:8080/serverPages/welcome", {method: "POST", body:JSON.stringify(member)})
    .then(function(res){
        return res.json();
    })
    .then(function(data){
        console.log(data);
        if(data.length){

            addMemberRes.innerText = "Added a new member " + data.firstname + " with the following details: ";

            for(let i = 0; i< data.length; i++){
                 let newMember = data[i];
                 const {firstname, address} = newMember;
                 console.log("First name is: " + firstname + "\n  Address is : " + address);
                  for(var key in newMember){
                    var item = document.createElement("p");
                    item.innerText = key + ": " + newMember[key];
                    memberDetails.append(item);
                  }
            }
        }

    }).catch(function(err){
        console.log(err);
        responseSection.append("<p style = 'color:red'>" + err.errorMessage + "</p>");
    });

})
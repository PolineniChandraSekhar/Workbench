
// JavaScript Document
//=====================================================
//' Purpose       :   Add items from one list to other
//' Source        :   Java Script
//' Author        :   Upendra Haputantry
//' Date Created  :   31-January-2012
//' Date Modified :   
//' Copyright By  :   Copyright � 2012 Virtusa Crop.
//'====================================================
var previousSelectedItem = false;


document.onclick = function(event){
    var event = event || window.event;
    if (!event.target) {
        event.target = event.srcElement
    }
    if (previousSelectedItem) {
    
        if ((event.target.parentNode.tagName !== "LI" && event.target.tagName !== "UL") && (previousSelectedItem.className === "item_selected")) {
        
            previousSelectedItem.className = "";
            
        }
    }
    
}

function add(){
    fromList = document.getElementById("FromList");
    toList = document.getElementById("ToList");
    var len = fromList.length;
    for (i = 0; i < len; i++) {
        if (fromList.options[i].selected) {
            var newOption = document.createElement("li");
            newOption.innerHTML ="<div style='width:210px;'>" + fromList.options[i].text + "</div><div style='width:70px;'><input type='checkbox' value='" + fromList.options[i].value + "' name='optionalSubjects'></div><div style='margin-left:5px;width:50px;'><input type='text' style='width: 40px; border: 1px solid rgb(70, 130, 180);' title='Enter to Maximum Mark relevant to Term ' value='100' ></div><div class='clearfix'></div>"; 

            toList.appendChild(newOption);
        }
    }
    for (j = 0; j < len; j++) {
        if (fromList.options[j].selected) {
            fromList.remove(j);
            j--;
            len--;
        }
    }
    
    var toListItems = document.getElementById("ToList").getElementsByTagName("li");
    
    for (var i = 0; i < toListItems.length; i++) {
        toListItems[i].onclick = function(){
            if (previousSelectedItem) {
                previousSelectedItem.className = "";
            }
            this.className = "item_selected";
            previousSelectedItem = this;
            
        }
    }
    
}


function remove(){
    var fromList = document.getElementById("FromList");
    var toListItems = document.getElementById("ToList").getElementsByTagName("li");
    
    for (var i = 0; i < toListItems.length; i++) {
        if (toListItems[i].className === "item_selected") {
            var newOption = document.createElement("option");
            newOption.setAttribute('value', toListItems[i].getElementsByTagName("input")[0].value);
            newOption.innerHTML = toListItems[i].getElementsByTagName("div")[0].innerHTML;
            fromList.appendChild(newOption);
            document.getElementById("ToList").removeChild(toListItems[i]);
        }
    }
    
}

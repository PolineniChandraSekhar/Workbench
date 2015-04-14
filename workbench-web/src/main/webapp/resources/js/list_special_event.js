/*
 * < ÀKURA, This application manages the daily activities of a Teacher and a Student of a School>
 *
 * Copyright (C) 2012 Virtusa Corporation.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

function add(){
fromList = document.getElementById("FromList");
toList = document.getElementById("ToList");
var len = fromList.length;
for (i = 0; i < len; i++) {
	if (fromList.options[i].selected) {
		var newOption = document.createElement("option");
		newOption.setAttribute('label', fromList.options[i].label);
		newOption.setAttribute('value', fromList.options[i].value);
		newOption.setAttribute('id', fromList.options[i].id);
		newOption.innerHTML = fromList.options[i].text;
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
}

function remove(){
fromList = document.getElementById("FromList");
toList = document.getElementById("ToList");
var groups = fromList.getElementsByTagName("optgroup");
var len = toList.length;
for (i = 0; i < len; i++) {
	if (toList.options[i].selected) {
		var newOption = document.createElement("option");
		newOption.setAttribute('label', toList.options[i].label);
		newOption.setAttribute('value', toList.options[i].value);
		newOption.setAttribute('id', toList.options[i].value);
		newOption.innerHTML = toList.options[i].text;
		fromList.appendChild(newOption);
		for (k = 0; k < groups.length; k++) {
			  if(toList.options[i].id === groups[k].label){
				   groups[k].appendChild(newOption);
				  }
			}
	}
}
for (j = 0; j < len; j++) {
	if (toList.options[j].selected) {
		toList.remove(j);
		j--;
		len--;
	}
}

}
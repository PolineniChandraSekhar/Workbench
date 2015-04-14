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

function add() {
	fromList = document.getElementById("FromList");
	toList = document.getElementById("ToList");
	var len = fromList.length;
	for (i = 0; i < len; i++) {
		if (fromList.options[i].selected) {
			var newOption = document.createElement("option");
			
			newOption.setAttribute('label', fromList.options[i].label);
			newOption.setAttribute('title', fromList.options[i].title);
			newOption.setAttribute('value', fromList.options[i].value);
			newOption.setAttribute('id', fromList.options[i].id);
			if ((fromList.options[i].title == 'Future Year Class Allocation Exist') || (fromList.options[i].title == 'Current Year Class Allocation Exist')) {
				newOption.setAttribute('class', "student_allocated");

			} else {
				newOption.setAttribute('class', "student_notallocated");

			}
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

function remove() {
	fromList = document.getElementById("FromList");
	toList = document.getElementById("ToList");
	var groups = fromList.getElementsByTagName("optgroup");
	var len = toList.length;
	for (i = 0; i < len; i++) {
		if (toList.options[i].selected) {
			var newOption = document.createElement("option");
			newOption.setAttribute('label', toList.options[i].label);
			newOption.setAttribute('title', toList.options[i].title);
			newOption.setAttribute('value', toList.options[i].value);
			newOption.setAttribute('id', toList.options[i].id);
			if ((toList.options[i].title == 'Future Year Class Allocation Exist') || (toList.options[i].title == 'Current Year Class Allocation Exist')) {
				newOption.setAttribute('class', "student_allocated");

			} else {
				newOption.setAttribute('class', "student_notallocated");

			}
			newOption.innerHTML = toList.options[i].text;

			for (k = 0; k < groups.length; k++) {
				if (toList.options[i].id === groups[k].label) {
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

function removeoptions() {
	fromList = document.getElementById("FromList");
	toList = document.getElementById("ToList");
	var groups = fromList.getElementsByTagName("option");
	var len = toList.length;
	for (i = 0; i < len; i++) {
		if (toList.options[i].selected) {
			var newOption = document.createElement("option");
			newOption.setAttribute('label', toList.options[i].label);
			newOption.setAttribute('title', toList.options[i].title);
			newOption.setAttribute('value', toList.options[i].value);
			newOption.setAttribute('id', toList.options[i].id);
			if ((toList.options[i].title == 'Future Year Class Allocation Exist') || (toList.options[i].title == 'Current Year Class Allocation Exist')) {
				newOption.setAttribute('class', "student_allocated");

			} else {
				newOption.setAttribute('class', "student_notallocated");

			}
			newOption.innerHTML = toList.options[i].text;

			fromList.appendChild(newOption);
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

// keeps the selected values on the To list and remove them from the from list
// when
// errors occurred.
function openMultipleSelect(selectedToArray, fromArray, splitComma, splitHypen) {

	// split from the comma.
	var splitArray = selectedToArray.split(splitComma);
	toList = document.getElementById("ToList");
	var len = splitArray.length;
	for (index = 0; index < len; index++) {

		var selectedOption = splitArray[index].split(splitHypen);
		var newOption = document.createElement("option");
		newOption.setAttribute('label', selectedOption[1]);
		newOption.setAttribute('title', selectedOption[0]);
		newOption.setAttribute('value', selectedOption[0]);
		newOption.setAttribute('id', selectedOption[0]);
		newOption.innerHTML = selectedOption[1];
		toList.appendChild(newOption);
	}

	// remove the selected objects from the from list.
	fromList = document.getElementById("FromList");
	var fromLength = fromList.length;
	var fromArrayList = fromArray.split(splitComma);

	for (index = 0; index < len; index++) { // iterates over the selected
											// values.
		var selectedOption = splitArray[index].split(splitHypen);
		for (indexFrom = 0; indexFrom < fromLength; indexFrom++) { // iterates
																	// over the
																	// from
																	// list.

			if (selectedOption[0] == fromList.options[indexFrom].value) {
				fromList.remove(indexFrom);
				indexFrom--;
				fromLength--;
			}
		}
	}
}
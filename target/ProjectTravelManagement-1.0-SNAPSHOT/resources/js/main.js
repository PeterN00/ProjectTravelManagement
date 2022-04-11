/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function displayImage(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#showimg').attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
        
        var btn = document.createElement("button");
        var text = document.createTextNode(" Remove Image");
        var icon = document.createElement("i");
        icon.className = "fa fa-close";

        btn.appendChild(icon);
        btn.appendChild(text);
        btn.style.backgroundColor = "Red";
        btn.id = 'removebtn';

        var btndiv = document.getElementById("removebtndiv");

        btn.addEventListener("click", function () {
            var img = document.getElementById("showimg");
            input.value = null;
            var curImg = document.getElementById("currentimg");
            if(curImg!=null){
                img.src = curImg.value;
            }else{
                img.src = 'https://res.cloudinary.com/petern/image/upload/v1649504989/travelmanagementproject_tourimg/Empty.jpg.jpg';
            }
            btndiv.removeChild(btn);
        });

        if (document.getElementById('removebtn') == null) {
            btndiv.appendChild(btn);
        }
    }
}

function calculatePrice(tourPrice, discount) {
    var price = 0;
    var priceDisplay = document.getElementById("price");
    var adult = document.getElementById("adultticket").value;
    var children = document.getElementById("childrenticket").value;
    price = tourPrice * adult + (tourPrice * children - tourPrice * children * discount / 100);
    priceDisplay.textContent = price + '$';
}

function getCurrentDateTime() {
    var d = new Date();
    var hours = d.getHours();
    var mins = d.getMinutes();
    var seconds = d.getSeconds();
    var day = d.getDate();
    var month = d.getMonth();
    var year = d.getFullYear();
    var bookDate = document.getElementById('currentDate');
    bookDate.value = year + "-" + month + "-" + day + "T" + hours + ":" + mins;
}

function displayMaxPriceRangeValue() {
    var range = document.getElementById("pricerange");
    var value = document.getElementById("maxvalue");
    value.textContent = range.value;
}

function drawChart(ctx, labels, data, type, label) {
    const myChart = new Chart(ctx, {
        type: type,
        data: {
            labels: labels,
            datasets: [{
                    label: label,
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 88, 35, 0.2)',
                        'rgba(122, 139, 44, 0.2)',
                        'rgba(200, 159, 24, 0.2)',
                        'rgba(48, 79, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 88, 35, 1)',
                        'rgba(122, 139, 44, 1)',
                        'rgba(200, 159, 24, 1)',
                        'rgba(48, 79, 64, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            },
            responsive: true,
            maintainAspectRatio: false
        }
    });
}

function addHighlightInput() {
    var input = document.createElement("input");
    input.style.cssText = 'margin-bottom: 1rem';
    input.id = 'highlight[]';
    input.name = 'highlight[]';
    input.placeholder = 'Highlight...';
    document.getElementById("highlightdiv").appendChild(input);
}
function removeLastHighlight() {
    var highlightdiv = document.getElementById('highlightdiv');
    var childs = highlightdiv.childNodes;
    if (childs.length > 0)
        highlightdiv.removeChild(highlightdiv.lastChild);
}

function addItineraryInput() {
    var div = document.createElement("div");
    div.style.cssText = 'display: flex; flex-direction: column; margin-bottom: 2rem;';
    var inputName = document.createElement("input");
    inputName.id = 'itineraryname[]';
    inputName.name = 'itineraryname[]';
    inputName.placeholder = 'Day (?): Doing?...';

    var inputDescription = document.createElement("textarea");
    inputDescription.id = 'itinerarydescription[]';
    inputDescription.name = 'itinerarydescription[]';
    inputDescription.placeholder = 'Itinerary Description...';
    inputDescription.rows = 3;
    inputDescription.cols = 70;

    div.appendChild(inputName);
    div.appendChild(inputDescription);

    document.getElementById("itinerarydiv").appendChild(div);
}
function removeLastItinerary() {
    var itinerarydiv = document.getElementById('itinerarydiv');
    var childs = itinerarydiv.childNodes;
    if (childs.length > 0)
        itinerarydiv.removeChild(itinerarydiv.lastChild);
}
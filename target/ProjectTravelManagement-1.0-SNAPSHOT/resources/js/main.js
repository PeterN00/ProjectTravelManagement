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
            input.value = '';
            img.src = '';
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

function drawChart(ctx, labels, data) {
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Booking',
                    data: data,
                    backgroundColor: [
                        '#96D4D4'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}
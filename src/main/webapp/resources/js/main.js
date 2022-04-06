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
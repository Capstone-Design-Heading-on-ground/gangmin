var selectedLine = document.getElementsByName('rd_line');
var div_line1 = document.getElementById('line1');
var div_line2 = document.getElementById('line2');

for(i=0; i<selectedLine.length;i++){
    selectedLine[i].addEventListener('click', function(){
        switch(this.id){
            case "p1" :
                div_line1.style.display = 'block';
                div_line2.style.display = 'none';
                break;
            case "p2" :
                div_line1.style.display = 'none';
                div_line2.style.display = 'block';
                break;
        }
    });
}

var selectedSubject = document.getElementsByName('rd_sub2');
var div_korean = document.getElementById('korean');
var div_math = document.getElementById('math');

for(i=0; i<selectedSubject.length;i++){
    selectedSubject[i].addEventListener('click', function(){
        switch(this.id){
            case "m1" :
                div_korean.style.display = 'block';
                div_math.style.display = 'none';
                break;
            case "m2" :
                div_korean.style.display = 'none';
                div_math.style.display = 'block';
                break;
            case "m3" :
            case "m4" :
            case "m5" :
            case "m6" :
                div_korean.style.display = 'none';
                div_math.style.display = 'none';
                break;
        }
    });
}

var selectedSubject2 = document.getElementsByName('rd_sub1');
for(i=0; i<selectedSubject2.length;i++){
    selectedSubject2[i].addEventListener('click', function(){
        switch(this.id){
            case "k1" :
                div_korean.style.display = 'block';
                div_math.style.display = 'none';
                break;
            case "k2" :
                div_korean.style.display = 'none';
                div_math.style.display = 'block';
                break;
            case "k3" :
            case "k4" :
            case "k5" :
            case "k6" :
                div_korean.style.display = 'none';
                div_math.style.display = 'none';
                break;
        }
    });
}


var radios = document.getElementsByName('radio_final');
var classes = document.getElementsByClassName('classes');
var checkEnglish1 = document.getElementsByName('rd_sub1');
var checkEnglish2 = document.getElementsByName('rd_sub2');

const arr1 = new Array();
arr1.push(document.getElementById('korean1'));
arr1.push(document.getElementById('korean2'));
arr1.push(document.getElementById('korean3'));
arr1.push(document.getElementById('math2'));
arr1.push(document.getElementById('math2'));
arr1.push(document.getElementById('math1'));
arr1.push(document.getElementById('math3'));
arr1.push(document.getElementById('math4'));
arr1.push(document.getElementById('english1'));
arr1.push(document.getElementById('english2'));




function clear(){
    for(var i=0, length=classes.length; i<length; i++){
        classes[i].style.display = 'none';
    }
}

function doSearch(){
    for(var i=0, length=radios.length; i<length; i++){
        if(radios[i].checked){
            clear();
            arr1[i].style.display = 'flex';
        }
    }
    if(checkEnglish1[2].checked || checkEnglish2[2].checked){
        clear();
        arr1[8].style.display = 'flex';
        arr1[9].style.display = 'flex';
    }
}
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
    
    //댓글보여주기
function showComment(comment){
    const userName = document.createElement('div');
    const inputValue = document.createElement('span');
    const showTime = document.createElement('div');
    const voteDiv = document.createElement('div');
    const countSpan = document.createElement('span')
    const voteUp = document.createElement('button');
    const voteDown = document.createElement('button');  
    const commentList = document.createElement('div');  //이놈이 스코프 밖으로 나가는 순간 하나지우면 다 지워지고 입력하면 리스트 다불러옴.
    //삭제버튼 만들기
    const delBtn = document.createElement('button');
    delBtn.className ="deleteComment";
    delBtn.innerHTML="삭제";
    commentList.className = "eachComment";
    userName.className="name";
    inputValue.className="inputValue";
    showTime.className="time";
    voteDiv.className="voteDiv";
    //유저네임가져오기 
    userName.innerHTML = generateUserName();    
    userName.appendChild(delBtn);  
    //입력값 넘기기
    inputValue.innerText = comment;
    //타임스템프찍기
    showTime.innerHTML = generateTime();
    countSpan.innerHTML=0;
    //투표창 만들기, css먼저 입혀야함.  
    voteUp.id = "voteUp";
    voteUp.innerHTML = '↑';    
    voteDown.id = "voteDown";
    voteDown.innerHTML = '↓';       
    voteDiv.appendChild(voteUp);
    voteDiv.appendChild(voteDown);

    //댓글뿌려주기       
    commentList.appendChild(userName);
    commentList.appendChild(inputValue);
    commentList.appendChild(showTime);
    commentList.appendChild(voteDiv);
    rootDiv.prepend(commentList);

    voteUp.addEventListener("click",numberCount);
    voteDown.addEventListener("click",numberCount);
    delBtn.addEventListener("click",deleteComments);
   console.dir(rootDiv);

}
}
function productCheck(){
	
	if(document.frm.name.value.length == 0){
		alert("상품명을 입력해주세요.");
		frm.name.focus();
		return false;
	}

	
	if(document.frm.price.value.length == 0){
		alert("가격을 입력해주세요.");
		frm.price.focus();
		return false;
	}

	if(isNaN(document.frm.price.value)){	//isNaN = 숫자가 아니면 true, 숫자이면 false
		alert("숫자를 입력해주세요.");
		frm.price.focus();
		return false;
		
	}
	return true;
}
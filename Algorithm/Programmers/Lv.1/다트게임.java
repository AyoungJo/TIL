class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int [] dart = new int[3]; //다트게임 문자열 3세트
        int idx = 0; //dart 인덱스
        String num = "";
        int convert = 0;
        int bonus = 0; // num에 보너스만큼 제곱 한 결과
        
        for(int i=0; i<dartResult.length(); i++){
            char div = dartResult.charAt(i); //문자열 나누기
            
           // System.out.println((int)div);
            //num += div - '0';
            if(div >= '0' && div <='9'){	//점수(숫자)
            	num +=  String.valueOf(div);
            }else if(div == 'S' || div=='D' || div=='T') {	//보너스
            	convert = Integer.parseInt(num);
            	if(div == 'S') { 		//1제곱
            		bonus = (int) Math.pow(convert, 1);
            	}else if(div == 'D') { 	//2제곱
            		bonus = (int) Math.pow(convert, 2);
            	}else if(div == 'T') {	//3제곱
            		bonus = (int) Math.pow(convert, 3);
            	}
            	dart[idx] = bonus; //첫번째 dart 점수 합산결과 저장
            	idx++;
            	num = "";			//다음 dart 점수 합산을 위해 빈 다트 초기화
            } else {	//옵션(필수 아님)
            	if(div == '*') {
            		dart[idx-1] *= 2;	//해당 점수 2배            		
            		//첫번째 dart라면 해당 dart점수에만 2배를 해야함
            		//첫번째 dart가 아니면 직전 dart에 2배를 할 수 있음
            		if(idx-2>=0) {//0번째 인덱스까지 2배 
            			dart[idx-2] *= 2;//이전 점수 2배	
            		} 
            	} else if(div == '#') {
            		dart[idx-1] *= (-1); //해당 점수 마이너스
            	}
            }
        }

        answer = dart[0] + dart[1] + dart[2];	//각 연산결과 합
        return answer;
    }
}

class sample{
    /***************PROBLEM-1*****************/
    /***************PROBLEM-2*****************/

    //TC:0(2*N)
//SC:0(1)
    class Solution {
        public boolean makesquare(int[] matchsticks) {
            if(matchsticks==null || matchsticks.length<4){
                return false;
            }
            int sum=0,max=0;
            for(int each:matchsticks){
                max=Math.max(max,each);
                sum+=each;
            }
            if(sum%4 !=0){
                return false;
            }
            int side=sum/4;
            if(max>side){
                return false;
            }
            return backtrack(matchsticks,side,0,new int[4]);
        }

        private boolean backtrack(int[] matchsticks,int side,int index,int[] square){
            //base
            if(index==matchsticks.length){
                if(square[0]==side && square[1]==side && square[2]==side){
                    return true;
                }
            }

            //logic
            for(int i=0;i<4;i++){
                if(matchsticks[index]+square[i]<=side){
                    //action
                    square[i]=matchsticks[index]+square[i];
                    //recurse
                    if(backtrack(matchsticks,side,index+1,square)){
                        return true;
                    }
                    //backtrack
                    square[i]=square[i]-matchsticks[index];
                }
            }
            return false;
        }
    }
}
package onlineexam._20180912_thunder;

import java.util.Scanner;

/**
 * 勾股数，是由三个正整数组成的数组；能符合勾股定理 a*a + b*b = c*c ， (a, b, c) 的正整数解。
 * 如果 (a, b, c) 是勾股数，它们的正整数倍数，也是勾股数。
 * 如果 (a, b, c) 互质，它们就称为素勾股数。给定正整数N，计算出小于或等于N的素勾股数个数。(0 < a <= b <= c <= N)
 * @author Administrator
 *
 */
public class NO1 {
	static int MAXN = 1000000;
	static int[] pri = new int[MAXN+10];
	static int pri_num;
	static int[] tab_phi = new int[MAXN+10];
	boolean temp[] = new boolean[MAXN+10];
	int T,num;
	int[] Dec= new int[20];
	int ans,n;
	

void print_prime()
{
    pri_num=0;
    for(int i=2;i<MAXN;i+=2) 
    	temp[i]=true;
    
    pri[pri_num++]=2;
    tab_phi[2]=1;
    tab_phi[1]=1;
    for(int i=3;i<MAXN;i+=2)
    {
        if(!temp[i]) {
        	pri[pri_num++]=i;
        	tab_phi[i]=i-1;	
        }
        for(int j=0;j<pri_num&&i*pri[j]<MAXN;j++)
        {
            temp[i*pri[j]]=true;
            if(i%pri[j]==0) {tab_phi[i*pri[j]]=tab_phi[i]*pri[j];break;}
            else tab_phi[i*pri[j]]=tab_phi[i]*(pri[j]-1);
        }
        if((((i+1)>>1)&1)==0) tab_phi[i+1]=tab_phi[(i+1)>>1]<<1;
        else  tab_phi[i+1]=tab_phi[(i+1)>>1];
    }
}


void prime_dec(int a)
{
    num=0;
    if(!temp[a]) {Dec[num++]=a; return;}
    for(int i=0;i<pri_num&&a>1;i++)
    {
        if(a%pri[i]==0)
        {
            Dec[num++]=pri[i];
            while(a%pri[i]==0)
            {
                a/=pri[i];
            }
            if(a>1&&(!temp[a])) {Dec[num++]=a; return;}
        }
    }
}


int dfs(int k,int l,int s,int a)
{
    if(k==num)
    {
        if((l&1)!=0) ans-=a/s;
        else ans+=a/s;
        return 0;
    }
    dfs(k+1,l,s,a);
    dfs(k+1,l+1,s*Dec[k],a);
    return 0;
}


int main()
{
    print_prime();
    ans=0;
		
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt(); 
    
    int m=(int)Math.sqrt(n+0.0);
    for(int i=m;i>0;i--)
    {
        int p=(int)Math.sqrt(n-(long)i*i+0.0);
        if((i&1)!=0)
        {
            prime_dec(i);
            if(i<=p) dfs(0,0,1,i>>1);
            else dfs(0,0,1,p>>1);
        }
        else
        {
            if(i<=p) ans+=tab_phi[i];
            else  { prime_dec(i); dfs(0,0,1,p); }
        }
    }
   
    System.out.println(ans);

    return 0;
}

	
	
}



package onlineexam._20180909_jd;

import java.util.Scanner;

/**
  ����n����Ʒ��ÿ����Ʒ���������� ai , bi , ci ��
  ����i��Ʒ���ϸ�Ʒ�������� : 
  ��������Ʒ j , ��aj>ai , bj>bi , cj>ci�����i��ƷΪ���ϸ�Ʒ
 * @author Administrator
 *
 */
public class NO2_compare {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [][] para = new int [num][3];
		for(int i=0; i<num; i++){
			para[i][0] = sc.nextInt();
			para[i][1] = sc.nextInt();
			para[i][2] = sc.nextInt();
		}

		int count=0;
		for (int i=0; i<num; i++) {
			for (int j=0; j<num; j++) {
				if (j!=i) {
					if (para[i][0]<para[j][0] && para[i][1]<para[j][1] && para[i][2]< para[j][2]) {
						count++;
						break;
					}
				}

			}
		}

		
		
		System.out.println(count);
		
		
	}
	
	
}


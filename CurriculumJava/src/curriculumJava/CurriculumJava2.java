package curriculumJava;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class CurriculumJava2 {

	public static void main(String[] args) {
		// コンソールに入力できるようにする
		Scanner scan = new Scanner(System.in);
		
		System.out.println("あなたの名前を入力してください。");
		boolean nameValidationFlag = false;
		String name = "";
		
		// 名前が正しく入力されるまで繰り返し
		while (!nameValidationFlag) {
			
			// 自分の名前を入力する
			name = scan.nextLine();
			
			// 名前が正常に入力されてない場合繰り返し
			if (!nameCheck(name)) {
				continue;
			}
			System.out.println("ユーザー名「" + name + "」を登録しました");
			nameValidationFlag = true;
		}
		
		// じゃんけんの手を配列に格納する
		String[] handArray = {"グー", "チョキ", "パー"};
		
		// 勝利した際にtrueになるフラグを宣言する
		boolean winFlag = false;
		
		// 勝負回数を格納
		int gameCount = 0;
		
		// 勝利するまで繰り返す
		while (!winFlag) {
			System.out.println("あなたが出す手を0～2の数字で入力してください「0：グー」「1：チョキ」「2：パー」");

			// 自分の手を入力する
			String myHandInput = scan.nextLine();
			
			// 入力した自分の手の範囲が0～2以外の場合エラー文を出力
			if (!checkHand(myHandInput)) {
				System.out.println("指定された数字を入力してください\n");
				continue;
			}
			
			int myHand = Integer.parseInt(myHandInput);
			
			System.out.println(name + "の手は「" + handArray[myHand] + "」");
			
			// 相手の手を生成
			Random ran = new Random();
			int enemy = ran.nextInt(3);

			System.out.println("相手の手は「" + handArray[enemy] + "」\n");
			
			// 勝負回数に+1する
			gameCount++;

			// あいこの場合
			if (myHand == enemy) {
				System.out.println("DRAW あいこ もう一回しましょう！\n");
			
			// 負けた場合
			} else if (
					// グーで負けた
					(myHand == 1 && enemy == 0) 
					// チョキで負けた
					|| (myHand == 2 && enemy == 1) 
					// パーで負けた
					|| (myHand == 0 && enemy == 2)) {
				
				// 自分が負けた手
				switch (enemy) {
					// グーの場合
					case 0:
						System.out.println("俺の勝ち！\n"
								+ "負けは次につながるチャンスです！\n"
								+ "ネバーギブアップ！\n");
						break;
					// チョキの場合
					case 1:
						System.out.println("俺の勝ち！\n"
								+ "たかがじゃんけん、そう思ってないですか？\n"
								+ "それやったら次も、俺が勝ちますよ\n");
						break;
					// パーの場合
					case 2:
						System.out.println("俺の勝ち！\n"
								+ "なんで負けたか、明日まで考えといてください。\n"
								+ "そしたら何かが見えてくるはずです\n");
						break;
				}
				
			// 勝った場合
			} else {
				System.out.println("やるやん。\n次は俺にリベンジさせて\n");
				System.out.println("勝つまでにかかった合計回数は" + gameCount + "回です");
				winFlag = true;
			}
		}
		scan.close();
	}
	
	// 入力された値が0～2まで確認
	private static Boolean checkHand(String myHandInput) {
		// 数字だけの正規表現
        String regex = "^[0-9]+$";

        // 数字の場合
		if (myHandInput.matches(regex)) {
			int myHand = Integer.parseInt(myHandInput);
			
			// 入力された数字が0より小さい、もしくは2より大きい場合
			if (myHand < 0 || myHand > 2) {
				return false;
			}
			// 0～2の場合
			return true;
		}
		// 数字以外の場合
		return false;
	}

	// 入力されたnameを確認
	private static Boolean nameCheck(String name) {
		// nullもしくは空文字の場合
		if (Objects.isNull(name) || name.isEmpty()) {
			System.out.println("名前を入力してください");
			return false;
		}
		
		// 10文字より大きい場合
		if (name.length() > 10) {
			System.out.println("名前を10文字以内にしてください");
			return false;
		}
		
		return true;
		
	}
}

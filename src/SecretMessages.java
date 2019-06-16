import java.util.Scanner;
public class SecretMessages {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);		
		String message = ""; //$NON-NLS-1$

		while (message.length() == 0) {
			System.out.println("Введите сообщение для шифровки/расшифровки:"); //$NON-NLS-1$
			message = scan.nextLine();
		}
		String playAgain = ""; //$NON-NLS-1$
		String output = ""; //$NON-NLS-1$

		int keyVal = 0;
		while (keyVal == 0) {
			System.out.println("Введите ключ (от –25 до 25):"); //$NON-NLS-1$

			try {
				keyVal = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		int tRier = 0;		
		char key = (char) keyVal;
		char key1 = (char) keyVal;
		do {
			//keyVal = key1;
			for (int x = 0; x < message.length(); x++) {
				//tRier++;
				char input = message.charAt(x);
				if (input >= 'А' && input <= 'Я') {
					input += key;
					if (input > 'Я')
						input -= 32;
					if (input < 'А')
						input += 32;
				} else if (input >= 'а' && input <= 'я') {
					input += key;
					if (input > 'я')
						input -= 32;
					if (input < 'а')
						input += 32;
				} else if (input >= '0' && input <= '9') {
					//key1 += input;
					input += (keyVal % 10);
					if (input > '9')
						input -= 10;
					if (input < '0')
						input += 10;
				} //English

				if (input >= 'A' && input <= 'Z') {
					input += key;
					if (input > 'Z')
						input -= 26;
					if (input < 'A')
						input += 26;
				} else if (input >= 'a' && input <= 'z') {
					input += key;
					if (input > 'z')
						input -= 26;
					if (input < 'a')
						input += 26;
					/*} else if (input >= '0' && input <= '9') {
					input += (keyVal % 10);
					if (input > '9')
						input -= 10;
					if (input < '0')
						input += 10;
				}*/

				} else if (Character.isWhitespace(input)) {
					input = '\u0459';
					//input += '&';
				}

				else if (input == '\u0459') {
					input = ' ';
				}

				else if (input == ',') {
					input = '\u045A';
				}

				else if (input == '\u045A') {
					input = ',';
				}

				output += input;

			}
			System.out.println(output);
			message = output;

			output = ""; //$NON-NLS-1$
			if (tRier < 1) {
				System.out.println("Расшифровать? д/н или y/n"); //$NON-NLS-1$			
				playAgain = scan.nextLine();
				//message = ""; //$NON-NLS-1$
				keyVal = key1 * -1;
				key = (char) (key * -1);
				tRier++;
				//playAgain = ""; //$NON-NLS-1$
			} else {
				playAgain = ""; //$NON-NLS-1$
			}


		} while ((playAgain.equalsIgnoreCase("y"))|(playAgain.equalsIgnoreCase("д"))); //$NON-NLS-1$ //$NON-NLS-2$

		scan.close();
	}
}


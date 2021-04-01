import java.io.*;
import java.util.*;

public class BAEK_10799 {

	static class Beam {
		int start;
		int end;

		public Beam(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static Stack<Integer> open = new Stack<>(); // ) �� �´� ( ��ġ ���

	static ArrayList<Integer> stickStart = new ArrayList<>(); // �踷����� ( �� ��ġ
	static ArrayList<Integer> stickEnd = new ArrayList<>(); // ) �� ��ġ
	static ArrayList<Beam> beams = new ArrayList<>(); // ������ ��ġ

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String stick = bf.readLine();

		for (int cur = 0; cur < stick.length(); cur++) {
			char point = stick.charAt(cur);

			if (point == '(') {
				open.add(cur);
			} else {
				int pos = open.pop(); // ���� ���� �� (�� ��ġ �A��

				if (cur - pos == 1) { // ���� ���̰� 1�̸� ������ ������ ��
					beams.add(new Beam(pos, cur));
				} else { // �ƴϸ� ����
					stickStart.add(pos);
					stickEnd.add(cur);
				}
			}
		}

		int cnt = 0;

		for (int i = 0; i < stickStart.size(); i++) {
			int start = stickStart.get(i);
			int end = stickEnd.get(i);

			int curCnt = 1;

			for (Beam beam : beams) {
				if (beam.start > start && beam.end < end) {
					curCnt++;
				}
			}
			cnt += curCnt;
		}

		System.out.println(cnt);
	}
}

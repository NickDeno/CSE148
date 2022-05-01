package p1;

public class StudentBag {

	private Student[] arr;
	private int nElems;

	public StudentBag(int maxSize) {
		arr = new Student[maxSize];
		nElems = 0;
	}

	public void insert(Student student) {
		arr[nElems++] = student;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	public Student findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (arr[i].getId().equals(id)) {
				return arr[i];
			}
		}
		return null;
	}

	public Student removeById(String id) {
		int i = 0;
		for (; i < nElems; i++) {
			if (arr[i].getId().equals(id)) {
				break;
			}
		}

		if (i == nElems) { // When there is no match found, return null
			return null;
		} else {
			Student temp = arr[i];
			for (int j = i; j < nElems - 1; j++) {
				arr[j] = arr[j + 1];
			}
			nElems--;
			return temp;

		}
	}

}

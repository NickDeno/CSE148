package app;

import model.Person;
import model.PersonBag;
import util.Backup;
import util.Restore;

public class Demo {
	
	public static void main(String[] args) {
//		PersonBag personBag = PersonBag.getPersonBag(100);
//		Person p1 = new Person("A");
//		Person p2 = new Person("B");
//		personBag.insert(p1);
//		personBag.insert(p2);
//		personBag.display();
//		
//		System.out.println("Show PersonBag under another name");
//		PersonBag newPersonBagName = PersonBag.getPersonBag(100);
//		newPersonBagName.display();
//		
//		Backup.backupPersonBag();
		
		PersonBag myPersonBag = Restore.restorePersonBag();
		myPersonBag.display();
		
	}
}

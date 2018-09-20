import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			System.out.print("Enter animal type: ");
			String type = in.nextLine();
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter owner name: ");
			String owner = in.nextLine();
			ListItem toAdd = new ListItem(type, name, owner);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			System.out.print("Enter the type to delete: ");
			String type = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter owner name to delete: ");
			String owner = in.nextLine();
			ListItem toDelete = new ListItem(type, name, owner);
			lih.deleteItem(toDelete);
			System.out.println("Deleted " + toDelete.getOwner() + "'s " + toDelete.getType() + ", " + toDelete.getName());
		}

		private static void editAnItem() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Type");
			System.out.println("2 : Search by Name");
			System.out.println("3 : Search by Owner");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListItem> foundItems;
			if (searchBy == 1)
			{
				System.out.print("Enter animal type: ");
				String type = in.nextLine();
				foundItems = lih.searchForItemByType(type);
			}
			else if (searchBy == 2)
			{
				System.out.print("Enter pet name: ");
				String name = in.nextLine();
				foundItems = lih.searchForItemByName(name);
			}
			else
			{
				System.out.print("Enter owner name: ");
				String owner = in.nextLine();
				foundItems = lih.searchForItemByOwner(owner);
			}
			
			if (!foundItems.isEmpty())
			{
				System.out.println("Found Results.");
				for (ListItem l : foundItems)
				{
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + ", " + toEdit.getOwner() + "'s " + toEdit.getType());
				System.out.println("1 : Update Type");
				System.out.println("2 : Update Pet Name");
				System.out.println("3 : Update Owner");
				System.out.println("4 : Cancel");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 2) {
					System.out.print("New Pet Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 3) {
					System.out.print("New Owner: ");
					String newOwner = in.nextLine();
					toEdit.setOwner(newOwner);
				} else if (update == 4) {
					// returns to menu
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add pet");
				System.out.println("*  2 -- Edit pet info");
				System.out.println("*  3 -- Remove pet");
				System.out.println("*  4 -- Find pet");
				System.out.println("*  5 -- Exit program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Type");
			System.out.println("2 : Search by Name");
			System.out.println("3 : Search by Owner");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListItem> foundItems;
			if (searchBy == 1)
			{
				System.out.print("Enter animal type: ");
				String type = in.nextLine();
				foundItems = lih.searchForItemByType(type);
			}
			else if (searchBy == 2)
			{
				System.out.print("Enter pet name: ");
				String name = in.nextLine();
				foundItems = lih.searchForItemByName(name);
			}
			else
			{
				System.out.print("Enter owner name: ");
				String owner = in.nextLine();
				foundItems = lih.searchForItemByOwner(owner);
			}
			
			if (!foundItems.isEmpty())
			{
				System.out.println("Found Results.");
				for (ListItem l : foundItems)
				{
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to view: ");
				int idToView = in.nextInt();

				ListItem toView = lih.searchForItemById(idToView);
				System.out.println("Retrieved " + toView.getName() + ", " + toView.getOwner() + "'s " + toView.getType());
			}
		}

	}
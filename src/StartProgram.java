import java.util.List;
import java.util.Scanner;

import controller.ListPuppyHelper;
import model.PuppyItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListPuppyHelper lph = new ListPuppyHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a puppy: ");
			String puppy = in.nextLine();
			System.out.print("Enter an breed: ");
			String breed = in.nextLine();
			PuppyItem toAdd = new PuppyItem(puppy, breed);
			lph.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the puppy to delete: ");
			String puppy = in.nextLine();
			System.out.print("Enter the breed to delete: ");
			String breed = in.nextLine();
			PuppyItem toDelete = new PuppyItem(puppy, breed);
			lph.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Puppy");
			System.out.println("2 : Search by Breed");
			int searchBy = in.nextInt();
			in.nextLine();
			List<PuppyItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the Puppy name: ");
				String puppyName = in.nextLine();
				foundItems = lph.searchForBreedByPuppy(puppyName);
			} else {
				System.out.print("Enter the Breed: ");
				String breedName = in.nextLine();
				foundItems = lph.searchForBreedByBreed(breedName);


			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (PuppyItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				PuppyItem toEdit = lph.searchForBreedById(idToEdit);
				System.out.println("Retrieved " + toEdit.getBreed() + " from " + toEdit.getPuppy());
				System.out.println("1 : Update Puppy");
				System.out.println("2 : Update Breed");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Puppy: ");
					String newPuppy = in.nextLine();
					toEdit.setPuppy(newPuppy);
				} else if (update == 2) {
					System.out.print("New Breed: ");
					String newBreed = in.nextLine();
					toEdit.setBreed(newBreed);
				}

				lph.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome Puppy list! ---");
			while (goAgain) {
				System.out.println("*  Select an choice below:");
				System.out.println("*  1 -- Add an puppy");
				System.out.println("*  2 -- Edit an puppy");
				System.out.println("*  3 -- Delete an puppy");
				System.out.println("*  4 -- View the list of puppy");
				System.out.println("*  5 -- Exit the awesome puppy program");
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
					lph.cleanUp();
					System.out.println("   Goodbye and thanks for using my program!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<PuppyItem> allItems = lph.showAllItems();
			for(PuppyItem singleItem: allItems) {
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}
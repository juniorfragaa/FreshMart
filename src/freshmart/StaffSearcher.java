package freshmart;

// StaffSearcher: I used a recursive Binary Search to find one staff member by name
// I based it on the BinarySearchRecursive from my lecturer, but it compares names (Strings)
public class StaffSearcher {

    // I look at the middle name and throw away the half where the name cannot be
    // the list must be sorted first, otherwise throwing half away makes no sense
    // O(log n): 30 names need at most 5 comparisons
    public static int binarySearch(StaffMember [] members, int left, int right, String searchName){

        if (left > right){    // base case: no names left to check, so the name is not in the list
            return -1;
        }
        int mid = left + (right - left) / 2;    // the middle position (lecturer's way, avoids overflow)
        // 0 = same name, > 0 = the middle name comes after, < 0 = it comes before
        int result = members[mid].getName().compareToIgnoreCase(searchName);

        if (result == 0){    // found it, so I give back its position
            return mid;
        }

        if (result > 0){     // the middle name comes after, so I search only the left half
            return binarySearch(members, left, (mid - 1), searchName);
        } else {             // the middle name comes before, so I search only the right half
            return binarySearch(members, (mid + 1), right, searchName);
        }
    }
}

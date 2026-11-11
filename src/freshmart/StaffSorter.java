package freshmart;

// StaffSorter: I used a recursive Merge Sort to put the staff in alphabetical order (A to Z)
// I based it on the MergeSort.java from my lecturer, but it sorts StaffMember records by name
public class StaffSorter {

    // I keep cutting the list in half and call mergeSort again on each half (recursion)
    // O(n log n) in every case
    public static void mergeSort(StaffMember [] members, int left, int right){

        if(left < right){                      // base case: if left == right there is only 1 record, so I stop
            int mid = (left + right)/2;        // the middle position (int drops the .5)
            mergeSort(members, left, mid);     // I sort the left half
            mergeSort(members, mid + 1, right);// I sort the right half
            merge(members, left, mid, right);  // I join the two sorted halves
        }
    }

    // I join two halves that are already sorted, by always taking the name that comes first
    public static void merge(StaffMember [] members, int left, int mid, int right){

        int n1 = mid - left + 1;    // how many records in the left half (mid is part of it)
        int n2 = right - mid;       // how many records in the right half

        // I copy both halves first, so I don't overwrite records I still need
        StaffMember[] L = new StaffMember [n1];
        StaffMember[] R = new StaffMember [n2];

        for (int i = 0; i < n1; i++)
            L[i] = members [left + i];
        for (int j = 0; j < n2; j++)
            R[j] = members[mid + 1 + j];

        int i = 0, j = 0, k = left;    // i = front of L, j = front of R, k = next chair in members
        while (i < n1 && j < n2){      // while both queues still have people
            // I compare the names; <= 0 means the left one comes first (or is equal),
            // and using <= keeps the sort stable
            if (L[i].getName().compareToIgnoreCase(R[j].getName()) <= 0){
                members[k] = L[i];
                i++;
            } else {
                members[k] = R[j];
                j++;
            }
            k++;
        }

        // one queue is empty, so the rest of the other one goes in (no comparison needed)
        while (i < n1){
            members[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            members[k] = R[j];
            j++;
            k++;
        }
    }
}

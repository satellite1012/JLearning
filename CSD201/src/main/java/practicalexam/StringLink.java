package practicalexam;

class StringLink {
      public String sData; // data item (key)
      public StringLink next; // next link in list
      // -------------------------------------------------------------

      public StringLink(String id, StringLink newNext) // constructor
      {
            sData = id;
            next = newNext;
      }

      // -------------------------------------------------------------
      public void displayLink() // display ourself
      {
            System.out.print("{" + sData + "} ");
      }
} // end class Link

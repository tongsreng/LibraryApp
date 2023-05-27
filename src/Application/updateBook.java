public void updateBooks(int[] bookIds, String[] titles, String[] authors, int[] years, String[] publishers, double[] costs) {

    // Validate the input parameters
    if (bookIds == null || bookIds.length == 0) {
        throw new IllegalArgumentException("No book IDs specified");
    }
    if (titles == null || titles.length != bookIds.length) {
        throw new IllegalArgumentException("Number of titles does not match number of book IDs");
    }
    if (authors == null || authors.length != bookIds.length) {
        throw new IllegalArgumentException("Number of authors does not match number of book IDs");
    }
    if (years == null || years.length != bookIds.length) {
        throw new IllegalArgumentException("Number of years does not match number of book IDs");
    }
    if (publishers == null || publishers.length != bookIds.length) {
        throw new IllegalArgumentException("Number of publishers does not match number of book IDs");
    }
    if (costs == null || costs.length != bookIds.length) {
        throw new IllegalArgumentException("Number of costs does not match number of book IDs");
    }

    // Start a transaction
    Transaction transaction = bookRepository.beginTransaction();

    // Update the books
    for (int i = 0; i < bookIds.length; i++) {
        Book book = bookRepository.findById(bookIds[i]);
        if (book == null) {
            transaction.rollback();
            throw new BookNotFoundException("Book with id " + bookIds[i] + " not found");
        }
        book.setTitle(titles[i]);
        book.setAuthor(authors[i]);
        book.setYear(years[i]);
        book.setPublisher(publishers[i]);
        book.setCost(costs[i]);
    }

    // Save the books
    bookRepository.saveAll(books);

    // Commit the transaction
    transaction.commit();
    //
}

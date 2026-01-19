This is a Java client-server application for tracking the work of a university library.
The server connects to a MySQL database (managed via SQLyog) and handles library operations, while the client provides a GUI for librarians.
The system’s UML model (included as an image in the repository) shows loans that can contain multiple books, each loan linked to one librarian and one student, students tied to one study level, and a many-to-many relationship between librarians and duty shifts.
Currently, the server includes forms for configuring the port, database connection, and server startup, while the client provides a librarian login form.

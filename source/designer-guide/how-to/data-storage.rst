Data Storage
============

|ivy| provides multiple possibilities to manage and store project
specific data. This chapter provides an overview of all the
possibilities with their advantages and disadvantages. Which one should
be used depends from case to case.

Content Management
------------------

Stores static multi language content like labels, texts, titles, images.
More information can be found in the chapter :ref:`cms`.

Web Content Folder
------------------

Stores static web files (CSS, JavaScript, Images, JSF-Templates) used in
HTML User Dialogs.

Filesystem
----------

Data can be stores in files. Access and management has to be implemented
in the project itself.

HTML User Dialog Resources
--------------------------

Stores static web files (CSS, JavaScript, Images, etc.) that are only
used in the HTML User Dialog.

Database
--------

Stores and access data in a database systems. An own database
server is necessary and the database schema must be managed outside of
|ivy|.
More information can be found in the chapter :ref:`process-element-db-activity`.

Persistency (Java Persistence API)
----------------------------------

Stores and access data in a database systems. An own database
server is necessary. The database schema can be generated. JPA is a Java
standard that is well documented and widely used. 
More information can be found in the chapter :ref:`persistence`.

Web Service
-----------

Stores and access data in external systems by using web services.
More information can be found in the chapter :ref:`process-element-web-service-call-activity`.

Variables
---------

Stores simple name/value configuration pairs. On the |ivy-engine| there is a :ref:`UI
<engine-cockpit-variables>` to change the values of a Variable. More information
can be found in the chapter :ref:`variables`.

User Properties
---------------

Stores simple name/value pairs per user. Can be used to store user
settings.
More information can be found in the Public API
:public-api:`IUser </ch/ivyteam/ivy/security/IUser.html>`.


Summary
-------

+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Concept                       | Overriding | Project Dependencies | Public API | Web Accessable | Designer UI | Engine UI | Knowledge |
+===============================+============+======================+============+================+=============+===========+===========+
| Content Management            | yes        | yes                  | yes        | (yes)          | yes         | no        | Novice    |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Web Content Folder            | no         | yes                  | no         | yes            | yes         | no        | Novice    |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Filesystem                    | no         | no                   | no         | no             | no          | no        | Advanced  |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| HTML User Dialog Resources    | no         | no                   | no         | yes            | yes         | no        | Novice    |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Database                      | no         | yes                  | no         | no             | yes         | no        | Advanced  |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Web Service                   | no         | yes                  | no         | no             | yes         | no        | Advanced  |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Persistency                   | no         | yes                  | yes        | no             | yes         | no        | Expert    |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| Variables                     | no         | yes                  | yes        | no             | yes         | yes       | Advanced  |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+
| User Properties               | no         | no                   | yes        | no             | no          | no        | Advanced  |
+-------------------------------+------------+----------------------+------------+----------------+-------------+-----------+-----------+

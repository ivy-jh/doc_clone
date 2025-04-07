.. _systemdb-case-insensitive-searches:

Case Insensitive Searches
=========================

If a case insensitive search is required, the affected column has to have a case
insensitive collation.

#. Check character set & collation of the column
#. Change character set & collation if necessary

.. rubric:: Character set and collation

All characters in databases are encoded with a specific character set (e.g.
utf8, latin1, cp1257). This defines which characters can be stored.

The collation is a set of rules that defines how the database management system
compares and orders the data (e.g., utf8_unicode_ci, latin2_general_ci). Common
abbreviations in the name of the collations are the following:

* ci = case insensitive
* cs = case sensitive
* ai = accent insensitive
* as = accent sensitive

Character set as well as collation can be defined on several levels in the
database system: server, database, table, or column. Everything about this
subject is specific to the database management system used; please refer to its
documentation for details.

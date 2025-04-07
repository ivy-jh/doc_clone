Writing
=======

You are able to write at runtime to the cms.
In this case it is necessary that you write 
in the CMS of the application. Because the 
cms of the application has the highest importance
(see :ref:`cms-content-resolution`) and the cms
of the application is always writeable
at runtime. 

.. code:: java

  var app = IApplication.current();
  var cms = ContentManagement.cms(app);
  cms.root()
    .child().string("myString")
    .value().get("en")
    .write().string("my content");

The data will be stored in the data directory of the application
which is :file:`[engineDir]/data/{app}/cms`.

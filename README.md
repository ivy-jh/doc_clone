# Axon Ivy Product Documentation

Based on [sphinx](http://www.sphinx-doc.org).
Uses reStructuredText as markup language.

**Note:** All Axon Ivy documentation must be written in English with *American spelling*!


## Build

Connect via VPN if working outside the office!

    # download images
    mvn clean package

    # build and serve doc
    docker compose up

You can browse the documentation at http://127.0.0.1:8000


## Dev Environment Setup

Use Eclipse or Visual Studio Code.

* **Eclipse**
    * [LiClipseText](https://marketplace.eclipse.org/content/liclipsetext)
      seems to be better maintained.
    * [ReST Editor](https://marketplace.eclipse.org/content/rest-editor)
      could be interesting but under active development.

* **Visual Studio Code**
    * Plugin *lextudio.restructuredtext* for syntax highlighting and code completion.
    * Plugin *rewrap* to wrap lines to 80 characters with ALT+Q
    * Plugin *Graphviz Interactive Preview* (by tintinweb) for interactive preview of our dot images.

* **Other Tools**
    * Use Grammarly plugins for online spell checking 
    * To work on Graphviz dot images, use https://sketchviz.com


## Guidelines

1. **Prevent big files**. If you use includes, the name of the included file should start with underscore.
2. **No binary files**. Use another repository for binary files.


## Drawings, Schematics and Images

Use [Graphviz](https://www.graphviz.org) to create this kind of artifact.
Use the following template to create new artifacts compatible with [Sketchviz](https://sketchviz.org):

    digraph your-name-here {
      layout=neato;

      node [shape=box, height="0.8", width="2", color="#007095", style=filled, fixedsize="true", margin=0, 
        fontname="Roboto,Helvetica Neue,Arial,sans-serif", fontcolor="white", fontsize=15
      ]; 
      
      /* nodes */
      
      /* edges */

      /* edge labels */

    }

When developing artifacts in Sketchviz,

- Uncheck the **Sketchy** checkbox to avoid the pencil-like drawing style
- Copy and paste your content between your editor and Sketchviz
- Refer to the dot images in the Axon Ivy documentation for reference
- standardize formats 
  - always quote numbers
  - keep number formats consistent
  - always use the same sequence of attributes
  - try to align attributes where useful - see existing dot files.


## Links

* [Sphinx](https://www.sphinx-doc.org/)
* [reStructuredtext Reference](http://www.sphinx-doc.org/en/master/usage/restructuredtext/index.html)
* [sphinx-rtd-theme demo](https://sphinx-rtd-theme.readthedocs.io/en/latest/demo/demo.html) and its [raw sources](https://raw.githubusercontent.com/rtfd/sphinx_rtd_theme/master/docs/demo/demo.rst)
* [reStructuredtext tables](https://rest-sphinx-memo.readthedocs.io/en/latest/ReST.html#tables)
* [GraphViz](http://graphviz.org)
* [Graphviz Object Attributes](http://graphviz.org/doc/info/attrs.html)
* [Graphviz DOT Language](http://graphviz.org/doc/info/lang.html)
* [SketchViz](https://sketchviz.com)


## Samples

- GUI elements

	:guilabel:`Next button'

- Files and Directories

	:file:`docker-entrypoint.sh`
	:file:`[engineDir]/configuration/defaults`

- Inline code

	:code:`docker run -p 8080:8080 axonivy/axonivy-engine:dev`

- Inline code block

	.. code-block:: bash
       
       docker run -p 8080:8080 axonivy/axonivy-engine

- Include code files

	.. literalinclude:: includes/docker-entrypoint.sh
       :language: bash
       :linenos:

- Links to dev.axonivy.com

	:dev-url:`Download </download>`

- Links to public api

	:public-api:`IvyPrimefacesThemeResolver </ch/ivyteam/ivy/jsf/primefaces/theme/IvyPrimefacesThemeResolver.html>`

- Warnings

	.. warning:: Attention! Make a backup!

- Tips

	.. tip:: Best Practice. Advice!

- External Link

	`Title <https://www.google.ch>`_ 

- Internal link (original title)

	:ref:`web-xml`

- Internal Link (custom title)

	:ref:`prepared <deployment-prepare>`

- Image

	.. figure:: images/workflow-demos.png

- Headings  

	# with overline, for parts
    * with overline, for chapters
    =, for sections (h1)
    -, for sub-sections (h2)
    ~, for sub-sub-sections (h3)
    ^, for sub-sub-sub-sections (h4)
    ", for paragraphs

- GUI descriptors

  Marks up the *actual UI text* of a navigation menu or form select element.
  
    Select :menuselection:`Help` from menu.

  When writing about multi-level menus, use a single ``:menuselection:`` role, and separate menu choices with ``-->``.

    To save your file, go to :menuselection:`File --> Save` in the Main Menu.


.. _release-notes:

Release Notes
=============

.. raw:: html

    <style>
      .wy-nav-content {
         max-width: 1200px;
      }

      #release-notes li {
        list-style: none;
        position: relative;
        padding-bottom: .25em;
        list-style-image: url('../../_images/feature.svg');
      }
      #release-notes h2 ~ p::before {
        content: '';
        mask: url('../../_images/warning.svg') no-repeat center;
        -webkit-mask: url('../../_images/warning.svg') no-repeat center;
        display: inline-block;
        width: 1.2em;
        height: 1.2em;
        background-color: #1b1b1b;
        margin-right: 0.2em;
        position: relative;
        top: 3px;
      }
      #improvements li {
        list-style-image: url('../../_images/improvement.svg');
      }
      #bugs li {
        list-style-image: url('../../_images/bug.svg');
      }
      #release-notes li::marker {
        font-size: 2em;
      }
      .badge {
        padding: 0.25em 0.4em;
        font-size: 75%;
        font-weight: 700;
        line-height: 1.5;
        text-align: center;
        white-space: nowrap;
        vertical-align: text-top;
      }
      .badge-pill {
        padding-right: 0.6em;
        padding-left: 0.6em;
        border-radius: 10rem;
      }
      .badge-success {
        color: #fff;
        background-color: #1e8f25;
      }
      .badge-success::before {
        content: '';
        display: inline-block;
        height: 1.2em;
        background-color: white;
        position: relative;
        top: 3px;
        margin-right: 0.2em;
      }
      .badge-performance::before {
        mask: url('../../_images/performance.svg') no-repeat center;
        -webkit-mask: url('../../_images/performance.svg') no-repeat center;
        width: 1.2em;
      }
      .badge-security {
        background-color: #9d9415;
      }
      .badge-security::before {
        mask: url('../../_images/security.svg') no-repeat center;
        -webkit-mask: url('../../_images/security.svg') no-repeat center;
        width: 1.2em;
      }
    </style>

.. include:: ../../../target/resources/includes/_release-notes.md
   :parser: myst_parser.sphinx_

.. include:: ../../../target/resources/includes/_release-notes-static.md
   :parser: myst_parser.sphinx_

Changes before 9.4.0
--------------------

.. literalinclude:: /../target/resources/includes/release-notes.txt
   :encoding: latin-1

.. |warning| image:: /_images/release-notes/warning.svg
.. |improvement| image:: /_images/release-notes/improvement.svg
.. |feature| image:: /_images/release-notes/feature.svg
.. |bug| image:: /_images/release-notes/bug.svg
.. |security| image:: /_images/release-notes/security.svg
.. |performance| image:: /_images/release-notes/performance.svg


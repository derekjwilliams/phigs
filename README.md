phigs
=====

Polyglottic Heterogeneous Interrelated Graph System

Scalable graph system that is agnostic about the data being stored with
the following caveats.  The data will have the notion of allowed relationships
to other entities.  The data will provide state required for signalling, more
relevantly simulations using the graph will be able to recover from failures.
Which is appropriate considering on if its primary intended uses is failure
anaylysis.  All business logic other than those will be handled externally.

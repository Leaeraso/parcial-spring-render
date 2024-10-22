package com.example.inicial1.config;

import com.example.inicial1.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object o) {
        final Revision r = (Revision) o;
    }
}

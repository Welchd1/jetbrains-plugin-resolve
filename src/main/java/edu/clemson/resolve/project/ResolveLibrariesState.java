package edu.clemson.resolve.project;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

class ResolveLibrariesState {
    @NotNull
    private Collection<String> urls = new ArrayList<>();

    @NotNull
    Collection<String> getUrls() {
        return urls;
    }

    void setUrls(@NotNull Collection<String> urls) {
        this.urls = urls;
    }
}

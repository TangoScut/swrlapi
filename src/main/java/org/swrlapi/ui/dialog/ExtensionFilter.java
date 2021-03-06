package org.swrlapi.ui.dialog;

import org.checkerframework.checker.nullness.qual.NonNull;

import javax.swing.filechooser.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A file filter the works on a particular extension.
 * <p>
 * Taken from Protege.
 *
 * @author Ray Fergerson fergerson@smi.stanford.edu
 */
public class ExtensionFilter extends FileFilter
{
  @NonNull private final List<@NonNull String> _extensions;
  @NonNull private final String _description;

  public ExtensionFilter(@NonNull Iterator<@NonNull String> extensions, @NonNull String description)
  {
    this._extensions = new ArrayList<>();
    while (extensions.hasNext()) {
      String extension = extensions.next();
      if (!extension.startsWith(".")) {
        extension = "." + extension;
      }
      this._extensions.add(extension);
    }
    this._description = description;
  }

  public ExtensionFilter(@NonNull String extension, @NonNull String description)
  {
    this(Collections.singleton(extension).iterator(), description);
  }

  @Override public boolean accept(java.io.File file)
  {
    if (file.isDirectory()) {
      return true;
    } else {
      String lowerCaseName = file.getName().toLowerCase();
      for (String s : this._extensions) {
        if (lowerCaseName.endsWith(s)) {
          return true;
        }
      }
      return false;
    }
  }

  @NonNull @Override public String getDescription()
  {
    String text;
    String es = "";
    Iterator<String> it = this._extensions.iterator();
    while (it.hasNext()) {
      String s = it.next();
      es += "*" + s;
      if (it.hasNext()) {
        es += ", ";
      }
    }
    if (this._description == null) {
      text = es + " files ";
    } else {
      text = this._description + " (" + es + ")";
    }
    return text;
  }
}

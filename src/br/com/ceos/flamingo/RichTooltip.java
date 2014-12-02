package br.com.ceos.flamingo;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RichTooltip {

  /**
   * The main title of this tooltip.
   *
   * @see #RichTooltip(String, String)
   * @see #setTitle(String)
   * @see #getTitle()
   */
  protected String title;

  /**
   * The main image of this tooltip. Can be <code>null</code>.
   *
   * @see #getMainImage()
   * @see #setMainImage(Image)
   */
  protected Image mainImage;

  /**
   * The description sections of this tooltip.
   *
   * @see #RichTooltip(String, String)
   * @see #addDescriptionSection(String)
   * @see #getDescriptionSections()
   */
  protected List<String> descriptionSections;

  /**
   * The footer image of this tooltip. Can be <code>null</code>.
   *
   * @see #getFooterImage()
   * @see #setFooterImage(Image)
   */
  protected Image footerImage;

  /**
   * The footer sections of this tooltip. Can be empty.
   *
   * @see #addFooterSection(String)
   * @see #getFooterSections()
   */
  protected List<String> footerSections;

  /**
   * Creates an empty tooltip.
   */
  public RichTooltip() {
  }

  /**
   * Creates a tooltip with the specified title and description section.
   *
   * @param title Tooltip title.
   * @param descriptionSection Tooltip main description section.
   */
  public RichTooltip(String title, String descriptionSection) {
    this.setTitle(title);
    this.addDescriptionSection(descriptionSection);
  }

  /**
   * Sets the title for this tooltip.
   *
   * @param title The new tooltip title.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets the main image for this tooltip.
   *
   * @param image The main image for this tooltip.
   * @see #getMainImage()
   * @see #addDescriptionSection(String)
   */
  public void setMainImage(Image image) {
    this.mainImage = image;
  }

  /**
   * Adds the specified description section to this tooltip.
   *
   * @param section The description section to add.
   * @see #getDescriptionSections()
   * @see #setMainImage(Image)
   * @see #setTitle(String)
   */
  public void addDescriptionSection(String section) {
    if (this.descriptionSections == null) {
      this.descriptionSections = new LinkedList<>();
    }
    this.descriptionSections.add(section);
  }

  /**
   * Sets the footer image for this tooltip.
   *
   * @param image The footer image for this tooltip.
   * @see #getFooterImage()
   * @see #addFooterSection(String)
   */
  public void setFooterImage(Image image) {
    this.footerImage = image;
  }

  /**
   * Adds the specified footer section to this tooltip.
   *
   * @param section The footer section to add.
   * @see #getFooterSections()
   * @see #setFooterImage(Image)
   */
  public void addFooterSection(String section) {
    if (this.footerSections == null) {
      this.footerSections = new LinkedList<String>();
    }
    this.footerSections.add(section);
  }

  /**
   * Returns the main title of this tooltip.
   *
   * @return The main title of this tooltip.
   * @see #RichTooltip(String, String)
   * @see #setTitle(String)
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the main image of this tooltip. Can return <code>null</code>.
   *
   * @return The main image of this tooltip.
   * @see #setMainImage(Image)
   * @see #getDescriptionSections()
   */
  public Image getMainImage() {
    return this.mainImage;
  }

  /**
   * Returns an unmodifiable list of description sections of this tooltip. Guaranteed to return a non-<code>null</code>
   * list.
   *
   * @return An unmodifiable list of description sections of this tooltip.
   * @see #RichTooltip(String, String)
   * @see #addDescriptionSection(String)
   * @see #getTitle()
   * @see #getMainImage()
   */
  @SuppressWarnings("unchecked")
  public List<String> getDescriptionSections() {
    if (this.descriptionSections == null) {
      return Collections.EMPTY_LIST;
    }
    return Collections.unmodifiableList(this.descriptionSections);
  }

  /**
   * Returns the footer image of this tooltip. Can return <code>null</code>.
   *
   * @return The footer image of this tooltip.
   * @see #setFooterImage(Image)
   * @see #getFooterSections()
   */
  public Image getFooterImage() {
    return this.footerImage;
  }

  /**
   * Returns an unmodifiable list of footer sections of this tooltip. Guaranteed to return a non-<code>null</code> list.
   *
   * @return An unmodifiable list of footer sections of this tooltip.
   * @see #addFooterSection(String)
   * @see #getFooterImage()
   */
  @SuppressWarnings("unchecked")
  public List<String> getFooterSections() {
    if (this.footerSections == null) {
      return Collections.EMPTY_LIST;
    }
    return Collections.unmodifiableList(this.footerSections);
  }
}

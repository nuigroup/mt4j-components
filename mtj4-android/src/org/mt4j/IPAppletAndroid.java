package org.mt4j;


public interface IPAppletAndroid {
//
////  /** Called with the activity is first created. */
////  public void onCreate(Bundle savedInstanceState);
////
////  public void onConfigurationChanged(Configuration newConfig);
//
//  /**
//   * Developers can override here to save state. The 'paused' variable will be
//   * set before this function is called.
//   */
//  public void pause();
//
//  /**
//   * Developers can override here to restore state. The 'paused' variable
//   * will be cleared before this function is called.
//   */
//  public void resume();
//
//  public void onDestroy();
//
////  // TODO this is only used by A2D, when finishing up a draw. but if the
////  // surfaceview has changed, then it might belong to an a3d surfaceview. hrm.
////  public SurfaceHolder getSurfaceHolder();
//
//  /**
//   * Called by the sketch surface view, thought it could conceivably be called
//   * by Android as well.
//   */
//  public void surfaceWindowFocusChanged(boolean hasFocus);
//
//  /**
//   * If you override this function without calling super.onTouchEvent(),
//   * then motionX, motionY, motionPressed, and motionEvent will not be set.
//   */
//  public boolean surfaceTouchEvent(MotionEvent event);
//
//  public boolean surfaceKeyDown(int code, KeyEvent event);
//
//  public boolean surfaceKeyUp(int code, KeyEvent event);
//
//  public int sketchWidth();
//
//  public int sketchHeight();
//
//  public String sketchRenderer();
//
//  public boolean sketchTranslucency();
//
//  public String sketchColordepth();
//
//  public void orientation(int which);
//
//  /**
//   * Called by the browser or applet viewer to inform this applet that it
//   * should start its execution. It is called after the init method and
//   * each time the applet is revisited in a Web page.
//   * <p/>
//   * Called explicitly via the first call to PApplet.paint(), because
//   * PAppletGL needs to have a usable screen before getting things rolling.
//   */
//  public void start();
//
//  /**
//   * Called by the browser or applet viewer to inform
//   * this applet that it should stop its execution.
//   * <p/>
//   * Unfortunately, there are no guarantees from the Java spec
//   * when or if stop() will be called (i.e. on browser quit,
//   * or when moving between web pages), and it's not always called.
//   */
//  public void stop();
//
//  /**
//   * Called by the browser or applet viewer to inform this applet
//   * that it is being reclaimed and that it should destroy
//   * any resources that it has allocated.
//   * <p/>
//   * This also attempts to call PApplet.stop(), in case there
//   * was an inadvertent override of the stop() function by a user.
//   * <p/>
//   * destroy() supposedly gets called as the applet viewer
//   * is shutting down the applet. stop() is called
//   * first, and then destroy() to really get rid of things.
//   * no guarantees on when they're run (on browser quit, or
//   * when moving between pages), though.
//   */
//  public void destroy();
//
//  public void setup();
//
//  public void draw();
//
//  /**
//   * Starts up and creates a two-dimensional drawing surface, or resizes the
//   * current drawing surface.
//   * <P>
//   * This should be the first thing called inside of setup().
//   * <P>
//   * If called once a renderer has already been set, this will use the
//   * previous renderer and simply resize it.
//   */
//  public void size(int iwidth, int iheight);
//
//  public void size(int iwidth, int iheight, String irenderer);
//
//  /**
//   * Creates a new PGraphics object and sets it to the specified size.
//   *
//   * Note that you cannot change the renderer once outside of setup().
//   * In most cases, you can call size() to give it a new size,
//   * but you need to always ask for the same renderer, otherwise
//   * you're gonna run into trouble.
//   *
//   * The size() method should *only* be called from inside the setup() or
//   * draw() methods, so that it is properly run on the main animation thread.
//   * To change the size of a PApplet externally, use setSize(), which will
//   * update the component size, and queue a resize of the renderer as well.
//   */
//  public void size(final int iwidth, final int iheight, final String irenderer,
//                   final String ipath);
//
//  /**
//   * Create an offscreen PGraphics object for drawing. This can be used
//   * for bitmap or vector images drawing or rendering.
//   * <UL>
//   * <LI>Do not use "new PGraphicsXxxx()", use this method. This method
//   * ensures that internal variables are set up properly that tie the
//   * new graphics context back to its parent PApplet.
//   * <LI>The basic way to create bitmap images is to use the <A
//   * HREF="http://processing.org/reference/saveFrame_.html">saveFrame()</A>
//   * function.
//   * <LI>If you want to create a really large scene and write that,
//   * first make sure that you've allocated a lot of memory in the Preferences.
//   * <LI>If you want to create images that are larger than the screen,
//   * you should create your own PGraphics object, draw to that, and use
//   * <A HREF="http://processing.org/reference/save_.html">save()</A>.
//   * For now, it's best to use <A HREF="http://dev.processing.org/reference/everything/javadoc/processing/core/PGraphics3D.html">P3D</A> in this scenario.
//   * P2D is currently disabled, and the JAVA2D default will give mixed
//   * results. An example of using P3D:
//   * <PRE>
//   *
//   * PGraphics big;
//   *
//   * void setup() {
//   *   big = createGraphics(3000, 3000, P3D);
//   *
//   *   big.beginDraw();
//   *   big.background(128);
//   *   big.line(20, 1800, 1800, 900);
//   *   // etc..
//   *   big.endDraw();
//   *
//   *   // make sure the file is written to the sketch folder
//   *   big.save("big.tif");
//   * }
//   *
//   * </PRE>
//   * <LI>It's important to always wrap drawing to createGraphics() with
//   * beginDraw() and endDraw() (beginFrame() and endFrame() prior to
//   * revision 0115). The reason is that the renderer needs to know when
//   * drawing has stopped, so that it can update itself internally.
//   * This also handles calling the defaults() method, for people familiar
//   * with that.
//   * <LI>It's not possible to use createGraphics() with the OPENGL renderer,
//   * because it doesn't allow offscreen use.
//   * <LI>With Processing 0115 and later, it's possible to write images in
//   * formats other than the default .tga and .tiff. The exact formats and
//   * background information can be found in the developer's reference for
//   * <A HREF="http://dev.processing.org/reference/core/javadoc/processing/core/PImage.html#save(java.lang.String)">PImage.save()</A>.
//   * </UL>
//   */
//  public PGraphics createGraphics(int iwidth, int iheight, String irenderer);
//
//  /**
//   * Preferred method of creating new PImage objects, ensures that a
//   * reference to the parent PApplet is included, which makes save() work
//   * without needing an absolute path.
//   */
//  public PImage createImage(int wide, int high, int format);
//
//  public PImage createImage(int wide, int high, int format, int sampling);
//
////  public PImage createImage(int wide, int high, PTexture.Parameters params);
//
//  /**
//   * Main method for the primary animation thread.
//   */
//  public void run();
//
//  public void handleDraw();
//
//  public void redraw();
//
//  public void loop();
//
//  public void noLoop();
//
//  public void mousePressed();
//
//  public void mouseReleased();
//
//  public void mouseDragged();
//
//  public void mouseMoved();
//
//  /**
//   * Called each time a single key on the keyboard is pressed.
//   * Because of how operating systems handle key repeats, holding
//   * down a key will cause multiple calls to keyPressed(), because
//   * the OS repeat takes over.
//   * <P>
//   * Examples for key handling:
//   * (Tested on Windows XP, please notify if different on other
//   * platforms, I have a feeling Mac OS and Linux may do otherwise)
//   * <PRE>
//   * 1. Pressing 'a' on the keyboard:
//   *    keyPressed  with key == 'a' and keyCode == 'A'
//   *    keyTyped    with key == 'a' and keyCode ==  0
//   *    keyReleased with key == 'a' and keyCode == 'A'
//   *
//   * 2. Pressing 'A' on the keyboard:
//   *    keyPressed  with key == 'A' and keyCode == 'A'
//   *    keyTyped    with key == 'A' and keyCode ==  0
//   *    keyReleased with key == 'A' and keyCode == 'A'
//   *
//   * 3. Pressing 'shift', then 'a' on the keyboard (caps lock is off):
//   *    keyPressed  with key == CODED and keyCode == SHIFT
//   *    keyPressed  with key == 'A'   and keyCode == 'A'
//   *    keyTyped    with key == 'A'   and keyCode == 0
//   *    keyReleased with key == 'A'   and keyCode == 'A'
//   *    keyReleased with key == CODED and keyCode == SHIFT
//   *
//   * 4. Holding down the 'a' key.
//   *    The following will happen several times,
//   *    depending on your machine's "key repeat rate" settings:
//   *    keyPressed  with key == 'a' and keyCode == 'A'
//   *    keyTyped    with key == 'a' and keyCode ==  0
//   *    When you finally let go, you'll get:
//   *    keyReleased with key == 'a' and keyCode == 'A'
//   *
//   * 5. Pressing and releasing the 'shift' key
//   *    keyPressed  with key == CODED and keyCode == SHIFT
//   *    keyReleased with key == CODED and keyCode == SHIFT
//   *    (note there is no keyTyped)
//   *
//   * 6. Pressing the tab key in an applet with Java 1.4 will
//   *    normally do nothing, but PApplet dynamically shuts
//   *    this behavior off if Java 1.4 is in use (tested 1.4.2_05 Windows).
//   *    Java 1.1 (Microsoft VM) passes the TAB key through normally.
//   *    Not tested on other platforms or for 1.3.
//   * </PRE>
//   */
//  public void keyPressed();
//
//  /**
//   * See keyPressed().
//   */
//  public void keyReleased();
//
//  /**
//   * Only called for "regular" keys like letters,
//   * see keyPressed() for full documentation.
//   */
//  public void keyTyped();
//
//  public void focusGained();
//
//  public void focusLost();
//
//  /**
//   * Get the number of milliseconds since the applet started.
//   * <P>
//   * This is a function, rather than a variable, because it may
//   * change multiple times per frame.
//   */
//  public int millis();
//
//  /**
//   * The delay() function causes the program to halt for a specified time.
//   * Delay times are specified in thousandths of a second. For example,
//   * running delay(3000) will stop the program for three seconds and
//   * delay(500) will stop the program for a half-second. Remember: the
//   * display window is updated only at the end of draw(), so putting more
//   * than one delay() inside draw() will simply add them together and the new
//   * frame will be drawn when the total delay is over.
//   * <br/> <br/>
//   * I'm not sure if this is even helpful anymore, as the screen isn't
//   * updated before or after the delay, meaning which means it just
//   * makes the app lock up temporarily.
//   */
//  public void delay(int napTime);
//
//  /**
//   * Set a target frameRate. This will cause delay() to be called
//   * after each frame so that the sketch synchronizes to a particular speed.
//   * Note that this only sets the maximum frame rate, it cannot be used to
//   * make a slow sketch go faster. Sketches have no default frame rate
//   * setting, and will attempt to use maximum processor power to achieve
//   * maximum speed.
//   */
//  public void frameRate(float newRateTarget);
//
//  /**
//     * Show status in the status bar of a web browser, or in the
//     * System.out console. Eventually this might show status in the
//     * p5 environment itself, rather than relying on the console.
//     */
//  //  public void status(String what) {
//  //    if (online) {
//  //      showStatus(what);
//  //
//  //    } else {
//  //      System.out.println(what);  // something more interesting?
//  //    }
//  //  }
//
//  public void link(String here);
//
//  /**
//   * Link to an external page without all the muss.
//   * <P>
//   * When run with an applet, uses the browser to open the url,
//   * for applications, attempts to launch a browser with the url.
//   * <P>
//   * Works on Mac OS X and Windows. For Linux, use:
//   * <PRE>open(new String[] { "firefox", url });</PRE>
//   * or whatever you want as your browser, since Linux doesn't
//   * yet have a standard method for launching URLs.
//   */
//  public void link(String url, String frameTitle);
//
//  /**
//   * Function for an applet/application to kill itself and
//   * display an error. Mostly this is here to be improved later.
//   */
//  public void die(String what);
//
//  /**
//   * Same as above but with an exception. Also needs work.
//   */
//  public void die(String what, Exception e);
//
//  /**
//   * Call to safely exit the sketch when finished. For instance,
//   * to render a single frame, save it, and quit.
//   */
//  public void exit();
//
//  /**
//   * Called to dispose of resources and shut down the sketch.
//   * Destroys the thread, dispose the renderer,and notify listeners.
//   * <p>
//   * Not to be called or overriden by users. If called multiple times,
//   * will only notify listeners once. Register a dispose listener instead.
//   */
//  public void dispose();
//
//  public void method(String name);
//
//  public void thread(final String name);
//
//  /**
//   * Intercepts any relative paths to make them absolute (relative
//   * to the sketch folder) before passing to save() in PImage.
//   * (Changed in 0100)
//   */
//  public void save(String filename);
//
//  /**
//   * Grab an image of what's currently in the drawing area and save it
//   * as a .tif or .tga file.
//   * <P>
//   * Best used just before endDraw() at the end of your draw().
//   * This can only create .tif or .tga images, so if neither extension
//   * is specified it defaults to writing a tiff and adds a .tif suffix.
//   */
//  public void saveFrame();
//
//  /**
//   * Save the current frame as a .tif or .tga image.
//   * <P>
//   * The String passed in can contain a series of # signs
//   * that will be replaced with the screengrab number.
//   * <PRE>
//   * i.e. saveFrame("blah-####.tif");
//   *      // saves a numbered tiff image, replacing the
//   *      // #### signs with zeros and the frame number </PRE>
//   */
//  public void saveFrame(String what);
//
//  /**
//   * Return a random number in the range [0, howbig).
//   * <P>
//   * The number returned will range from zero up to
//   * (but not including) 'howbig'.
//   */
//  public float random(float howbig);
//
//  /**
//   * Return a random number in the range [howsmall, howbig).
//   * <P>
//   * The number returned will range from 'howsmall' up to
//   * (but not including 'howbig'.
//   * <P>
//   * If howsmall is >= howbig, howsmall will be returned,
//   * meaning that random(5, 5) will return 5 (useful)
//   * and random(7, 4) will return 7 (not useful.. better idea?)
//   */
//  public float random(float howsmall, float howbig);
//
//  public void randomSeed(long what);
//
//  /**
//   * Computes the Perlin noise function value at point x.
//   */
//  public float noise(float x);
//
//  /**
//   * Computes the Perlin noise function value at the point x, y.
//   */
//  public float noise(float x, float y);
//
//  /**
//   * Computes the Perlin noise function value at x, y, z.
//   */
//  public float noise(float x, float y, float z);
//
//  public void noiseDetail(int lod);
//
//  public void noiseDetail(int lod, float falloff);
//
//  public void noiseSeed(long what);
//
//  public PImage loadImage(String filename);
//
//  public PImage loadImage(String filename, int sampling);
//
////  public PImage loadImage(String filename, PTexture.Parameters params);
//
//  public PImage requestImage(String filename);
//
//  /**
//   * Load a geometry from a file as a PShape (either an SVG or OBJ file).
//   */
//  public PShape loadShape(String filename);
//
//  /**
//   * Load a geometry from a file as a PShape (either an SVG or OBJ file).
//   */
//  public PShape loadShape(String filename, int mode);
//
//  /**
//   * Creates an empty, static 3D shape, with space for nvert vertices.
//   */
//  public PShape3D createShape(int nvert, int kind);
//
//  /**
//   * Creates an empty 3D shape, with space for nvert vertices.
//   */
//  public PShape3D createShape(int nvert, int kind, int mode);
//
//  /**
//   * Tesselates a PShape into a static PShape3D (it cannot be modified during the drawing loop).
//   */
//  public PShape3D createShape(PShape shape);
//
//  /**
//   * Tesselates a PShape into a PShape3D with the desired drawing mode (STATID or DYNAMIC)..
//   */
//  public PShape3D createShape(PShape shape, int mode);
//
//  public PFont loadFont(String filename);
//
//  public PFont createFont(String name, float size);
//
//  public PFont createFont(String name, float size, boolean smooth);
//
//  /**
//   * Create a bitmap font on the fly from either a font name that's
//   * installed on the system, or from a .ttf or .otf that's inside
//   * the data folder of this sketch.
//   * <P/>
//   * Use 'null' for the charset if you want to dynamically create
//   * character bitmaps only as they're needed.
//   */
//  public PFont createFont(String name, float size, boolean smooth,
//                          char[] charset);
//
//  /**
//   * I want to read lines from a file. I have RSI from typing these
//   * eight lines of code so many times.
//   */
//  public BufferedReader createReader(String filename);
//
//  /**
//   * I want to print lines to a file. Why can't I?
//   */
//  public PrintWriter createWriter(String filename);
//
//  /**
//   * Simplified method to open a Java InputStream.
//   * <P>
//   * This method is useful if you want to use the facilities provided
//   * by PApplet to easily open things from the data folder or from a URL,
//   * but want an InputStream object so that you can use other Java
//   * methods to take more control of how the stream is read.
//   * <P>
//   * If the requested item doesn't exist, null is returned.
//   * (Prior to 0096, die() would be called, killing the applet)
//   * <P>
//   * For 0096+, the "data" folder is exported intact with subfolders,
//   * and openStream() properly handles subdirectories from the data folder
//   * <P>
//   * If not online, this will also check to see if the user is asking
//   * for a file whose name isn't properly capitalized. This helps prevent
//   * issues when a sketch is exported to the web, where case sensitivity
//   * matters, as opposed to Windows and the Mac OS default where
//   * case sensitivity is preserved but ignored.
//   * <P>
//   * It is strongly recommended that libraries use this method to open
//   * data files, so that the loading sequence is handled in the same way
//   * as functions like loadBytes(), loadImage(), etc.
//   * <P>
//   * The filename passed in can be:
//   * <UL>
//   * <LI>A URL, for instance openStream("http://processing.org/");
//   * <LI>A file in the sketch's data folder
//   * <LI>Another file to be opened locally (when running as an application)
//   * </UL>
//   */
//  public InputStream createInput(String filename);
//
//  /**
//   * Call createInput() without automatic gzip decompression.
//   */
//  public InputStream createInputRaw(String filename);
//
//  public byte[] loadBytes(String filename);
//
//  /**
//   * Load data from a file and shove it into a String array.
//   * <P>
//   * Exceptions are handled internally, when an error, occurs, an
//   * exception is printed to the console and 'null' is returned,
//   * but the program continues running. This is a tradeoff between
//   * 1) showing the user that there was a problem but 2) not requiring
//   * that all i/o code is contained in try/catch blocks, for the sake
//   * of new users (or people who are just trying to get things done
//   * in a "scripting" fashion. If you want to handle exceptions,
//   * use Java methods for I/O.
//   */
//  public String[] loadStrings(String filename);
//
//  /**
//   * Similar to createInput() (formerly openStream), this creates a Java
//   * OutputStream for a given filename or path. The file will be created in
//   * the sketch folder, or in the same folder as an exported application.
//   * <p/>
//   * If the path does not exist, intermediate folders will be created. If an
//   * exception occurs, it will be printed to the console, and null will be
//   * returned.
//   * <p/>
//   * Future releases may also add support for handling HTTP POST via this
//   * method (for better symmetry with createInput), however that's maybe a
//   * little too clever (and then we'd have to add the same features to the
//   * other file functions like createWriter). Who you callin' bloated?
//   */
//  public OutputStream createOutput(String filename);
//
//  /**
//   * Save the contents of a stream to a file in the sketch folder.
//   * This is basically saveBytes(blah, loadBytes()), but done
//   * more efficiently (and with less confusing syntax).
//   */
//  public boolean saveStream(String targetFilename, String sourceLocation);
//
//  /**
//   * Identical to the other saveStream(), but writes to a File
//   * object, for greater control over the file location.
//   * Note that unlike other api methods, this will not automatically
//   * compress or uncompress gzip files.
//   */
//  public boolean saveStream(File targetFile, String sourceLocation);
//
//  public boolean saveStream(String targetFilename, InputStream sourceStream);
//
//  /**
//   * Saves bytes to a file to inside the sketch folder.
//   * The filename can be a relative path, i.e. "poo/bytefun.txt"
//   * would save to a file named "bytefun.txt" to a subfolder
//   * called 'poo' inside the sketch folder. If the in-between
//   * subfolders don't exist, they'll be created.
//   */
//  public void saveBytes(String filename, byte buffer[]);
//
//  public void saveStrings(String filename, String strings[]);
//
//  /**
//   * Prepend the sketch folder path to the filename (or path) that is
//   * passed in. External libraries should use this function to save to
//   * the sketch folder.
//   * <p/>
//   * Note that when running as an applet inside a web browser,
//   * the sketchPath will be set to null, because security restrictions
//   * prevent applets from accessing that information.
//   * <p/>
//   * This will also cause an error if the sketch is not inited properly,
//   * meaning that init() was never called on the PApplet when hosted
//   * my some other main() or by other code. For proper use of init(),
//   * see the examples in the main description text for PApplet.
//   */
//  public String sketchPath(String where);
//
//  public File sketchFile(String where);
//
//  /**
//   * Returns a path inside the applet folder to save to. Like sketchPath(),
//   * but creates any in-between folders so that things save properly.
//   * <p/>
//   * All saveXxxx() functions use the path to the sketch folder, rather than
//   * its data folder. Once exported, the data folder will be found inside the
//   * jar file of the exported application or applet. In this case, it's not
//   * possible to save data into the jar file, because it will often be running
//   * from a server, or marked in-use if running from a local file system.
//   * With this in mind, saving to the data path doesn't make sense anyway.
//   * If you know you're running locally, and want to save to the data folder,
//   * use <TT>saveXxxx("data/blah.dat")</TT>.
//   */
//  public String savePath(String where);
//
//  /**
//   * Identical to savePath(), but returns a File object.
//   */
//  public File saveFile(String where);
//
//  /**
//   * Return a full path to an item in the data folder.
//   * <p>
//   * In this method, the data path is defined not as the applet's actual
//   * data path, but a folder titled "data" in the sketch's working
//   * directory. When running inside the PDE, this will be the sketch's
//   * "data" folder. However, when exported (as application or applet),
//   * sketch's data folder is exported as part of the applications jar file,
//   * and it's not possible to read/write from the jar file in a generic way.
//   * If you need to read data from the jar file, you should use createInput().
//   */
//  public String dataPath(String where);
//
//  /**
//   * Return a full path to an item in the data folder as a File object.
//   * See the dataPath() method for more information.
//   */
//  public File dataFile(String where);
//
//  public int color(int gray);
//
//  public int color(float fgray);
//
//  /**
//   * As of 0116 this also takes color(#FF8800, alpha)
//   */
//  public int color(int gray, int alpha);
//
//  public int color(float fgray, float falpha);
//
//  public int color(int x, int y, int z);
//
//  public int color(float x, float y, float z);
//
//  public int color(int x, int y, int z, int a);
//
//  public int color(float x, float y, float z, float a);
//
//  /**
//   * Override the g.pixels[] function to set the pixels[] array
//   * that's part of the PApplet object. Allows the use of
//   * pixels[] in the code, rather than g.pixels[].
//   */
//  public void loadPixels();
//
//  public void updatePixels();
//
//  public void updatePixels(int x1, int y1, int x2, int y2);
//
//  public void flush();
//
//  public void hint(int which);
//
//  public void beginShape();
//
//  public void beginShape(int kind);
//
////  public PShape beginRecord();
////
////  public void beginShapesRecorder();
////
////  public void beginShapeRecorder();
////
////  public void beginShapeRecorder(int kind);
//
//  public void edge(boolean edge);
//
////  public void autoNormal(boolean auto);
//
//  public void normal(float nx, float ny, float nz);
//
//  public void textureMode(int mode);
//
//  public void texture(PImage image);
//
//  public void noTexture();
//
//  public void vertex(float x, float y);
//
//  public void vertex(float x, float y, float z);
//
//  public void vertex(float[] v);
//
//  public void vertex(float x, float y, float u, float v);
//
//  public void vertex(float x, float y, float z, float u, float v);
//
//  public void breakShape();
//
//  public void endShape();
//
//  public void endShape(int mode);
//
//  public void endRecord();
//
//  public PShape3D endShapesRecorder();
//
//  public PShape3D endShapeRecorder();
//
//  public PShape3D endShapeRecorder(int mode);
//
//  public void bezierVertex(float x2, float y2, float x3, float y3, float x4,
//                           float y4);
//
//  public void bezierVertex(float x2, float y2, float z2, float x3, float y3,
//                           float z3, float x4, float y4, float z4);
//
//  public void curveVertex(float x, float y);
//
//  public void curveVertex(float x, float y, float z);
//
//  public void point(float x, float y);
//
//  public void point(float x, float y, float z);
//
//  public void line(float x1, float y1, float x2, float y2);
//
//  public void line(float x1, float y1, float z1, float x2, float y2, float z2);
//
//  public void triangle(float x1, float y1, float x2, float y2, float x3,
//                       float y3);
//
//  public void quad(float x1, float y1, float x2, float y2, float x3, float y3,
//                   float x4, float y4);
//
//  public void rectMode(int mode);
//
//  public void rect(float a, float b, float c, float d);
//
//  public void ellipseMode(int mode);
//
//  public void ellipse(float a, float b, float c, float d);
//
//  public void arc(float a, float b, float c, float d, float start, float stop);
//
//  public void box(float size);
//
//  public void box(float w, float h, float d);
//
//  public void sphereDetail(int res);
//
//  public void sphereDetail(int ures, int vres);
//
//  public void sphere(float r);
//
//  public float bezierPoint(float a, float b, float c, float d, float t);
//
//  public float bezierTangent(float a, float b, float c, float d, float t);
//
//  public void bezierDetail(int detail);
//
//  public void bezier(float x1, float y1, float x2, float y2, float x3,
//                     float y3, float x4, float y4);
//
//  public void bezier(float x1, float y1, float z1, float x2, float y2,
//                     float z2, float x3, float y3, float z3, float x4,
//                     float y4, float z4);
//
//  public float curvePoint(float a, float b, float c, float d, float t);
//
//  public float curveTangent(float a, float b, float c, float d, float t);
//
//  public void curveDetail(int detail);
//
//  public void curveTightness(float tightness);
//
//  public void curve(float x1, float y1, float x2, float y2, float x3, float y3,
//                    float x4, float y4);
//
//  public void curve(float x1, float y1, float z1, float x2, float y2, float z2,
//                    float x3, float y3, float z3, float x4, float y4, float z4);
//
//  public void smooth();
//
//  public void noSmooth();
//
//  public void imageMode(int mode);
//
//  public void image(PImage image, float x, float y);
//
//  public void image(PImage image, float x, float y, float c, float d);
//
//  public void image(PImage image, float a, float b, float c, float d, int u1,
//                    int v1, int u2, int v2);
//
//  public void shapeMode(int mode);
//
//  public void shape(PShape shape);
//
//  public void shape(PShape shape, float x, float y);
//
//  public void shape(PShape shape, float x, float y, float z);
//
//  public void shape(PShape shape, float x, float y, float c, float d);
//
//  public void shape(PShape shape, float x, float y, float z, float c, float d,
//                    float e);
//
//  public void textAlign(int align);
//
//  public void textAlign(int alignX, int alignY);
//
//  public float textAscent();
//
//  public float textDescent();
//
//  public void textFont(PFont which);
//
//  public void textFont(PFont which, float size);
//
//  public void textLeading(float leading);
//
//  public void textMode(int mode);
//
//  public void textSize(float size);
//
//  public float textWidth(char c);
//
//  public float textWidth(String str);
//
//  public void text(char c);
//
//  public void text(char c, float x, float y);
//
//  public void text(char c, float x, float y, float z);
//
//  public void text(String str);
//
//  public void text(String str, float x, float y);
//
//  public void text(String str, float x, float y, float z);
//
//  public void text(String str, float x1, float y1, float x2, float y2);
//
//  public void text(String s, float x1, float y1, float x2, float y2, float z);
//
//  public void text(int num, float x, float y);
//
//  public void text(int num, float x, float y, float z);
//
//  public void text(float num, float x, float y);
//
//  public void text(float num, float x, float y, float z);
//
//  public void pushMatrix();
//
//  public void popMatrix();
//
//  public void translate(float tx, float ty);
//
//  public void translate(float tx, float ty, float tz);
//
//  public void rotate(float angle);
//
//  public void rotateX(float angle);
//
//  public void rotateY(float angle);
//
//  public void rotateZ(float angle);
//
//  public void rotate(float angle, float vx, float vy, float vz);
//
//  public void scale(float s);
//
//  public void scale(float sx, float sy);
//
//  public void scale(float x, float y, float z);
//
//  public void shearX(float angle);
//
//  public void shearY(float angle);
//
//  public void resetMatrix();
//
//  public void applyMatrix(PMatrix source);
//
//  public void applyMatrix(PMatrix2D source);
//
//  public void applyMatrix(float n00, float n01, float n02, float n10,
//                          float n11, float n12);
//
//  public void applyMatrix(PMatrix3D source);
//
//  public void applyMatrix(float n00, float n01, float n02, float n03,
//                          float n10, float n11, float n12, float n13,
//                          float n20, float n21, float n22, float n23,
//                          float n30, float n31, float n32, float n33);
//
//  public PMatrix getMatrix();
//
//  public PMatrix2D getMatrix(PMatrix2D target);
//
//  public PMatrix3D getMatrix(PMatrix3D target);
//
//  public void setMatrix(PMatrix source);
//
//  public void setMatrix(PMatrix2D source);
//
//  public void setMatrix(PMatrix3D source);
//
//  public void printMatrix();
//
//  public void beginCamera();
//
//  public void endCamera();
//
//  public void camera();
//
//  public void camera(float eyeX, float eyeY, float eyeZ, float centerX,
//                     float centerY, float centerZ, float upX, float upY,
//                     float upZ);
//
//  public void printCamera();
//
//  public void ortho();
//
//  public void ortho(float left, float right, float bottom, float top);
//
//  public void ortho(float left, float right, float bottom, float top,
//                    float near, float far);
//
//  public void perspective();
//
//  public void perspective(float fovy, float aspect, float zNear, float zFar);
//
//  public void frustum(float left, float right, float bottom, float top,
//                      float near, float far);
//
//  public void printProjection();
//
//  public float screenX(float x, float y);
//
//  public float screenY(float x, float y);
//
//  public float screenX(float x, float y, float z);
//
//  public float screenY(float x, float y, float z);
//
//  public float screenZ(float x, float y, float z);
//
//  public float modelX(float x, float y, float z);
//
//  public float modelY(float x, float y, float z);
//
//  public float modelZ(float x, float y, float z);
//
//  public void pushStyle();
//
//  public void popStyle();
//
//  public void style(PStyle s);
//
//  public void strokeWeight(float weight);
//
//  public void strokeJoin(int join);
//
//  public void strokeCap(int cap);
//
//  public void noStroke();
//
//  public void stroke(int rgb);
//
//  public void stroke(int rgb, float alpha);
//
//  public void stroke(float gray);
//
//  public void stroke(float gray, float alpha);
//
//  public void stroke(float x, float y, float z);
//
//  public void stroke(float x, float y, float z, float a);
//
//  public void noTint();
//
//  public void tint(int rgb);
//
//  public void tint(int rgb, float alpha);
//
//  public void tint(float gray);
//
//  public void tint(float gray, float alpha);
//
//  public void tint(float x, float y, float z);
//
//  public void tint(float x, float y, float z, float a);
//
//  public void noFill();
//
//  public void fill(int rgb);
//
//  public void fill(int rgb, float alpha);
//
//  public void fill(float gray);
//
//  public void fill(float gray, float alpha);
//
//  public void fill(float x, float y, float z);
//
//  public void fill(float x, float y, float z, float a);
//
//  public void ambient(int rgb);
//
//  public void ambient(float gray);
//
//  public void ambient(float x, float y, float z);
//
//  public void specular(int rgb);
//
//  public void specular(float gray);
//
//  public void specular(float x, float y, float z);
//
//  public void shininess(float shine);
//
//  public void emissive(int rgb);
//
//  public void emissive(float gray);
//
//  public void emissive(float x, float y, float z);
//
//  public void lights();
//
//  public void noLights();
//
//  public void ambientLight(float red, float green, float blue);
//
//  public void ambientLight(float red, float green, float blue, float x,
//                           float y, float z);
//
//  public void directionalLight(float red, float green, float blue, float nx,
//                               float ny, float nz);
//
//  public void pointLight(float red, float green, float blue, float x, float y,
//                         float z);
//
//  public void spotLight(float red, float green, float blue, float x, float y,
//                        float z, float nx, float ny, float nz, float angle,
//                        float concentration);
//
//  public void lightFalloff(float constant, float linear, float quadratic);
//
//  public void lightSpecular(float x, float y, float z);
//
//  public void background(int rgb);
//
//  public void background(int rgb, float alpha);
//
//  public void background(float gray);
//
//  public void background(float gray, float alpha);
//
//  public void background(float x, float y, float z);
//
//  public void background(float x, float y, float z, float a);
//
//  public void background(PImage image);
//
//  public void colorMode(int mode);
//
//  public void colorMode(int mode, float max);
//
//  public void colorMode(int mode, float maxX, float maxY, float maxZ);
//
//  public void colorMode(int mode, float maxX, float maxY, float maxZ, float maxA);
//
//  public float alpha(int what);
//
//  public float red(int what);
//
//  public float green(int what);
//
//  public float blue(int what);
//
//  public float hue(int what);
//
//  public float saturation(int what);
//
//  public float brightness(int what);
//
//  public int lerpColor(int c1, int c2, float amt);
//
//  public boolean displayable();
//
//  public void setCache(Object parent, Object storage);
//
//  public Object getCache(Object parent);
//
//  public void removeCache(Object parent);
//
//  public int get(int x, int y);
//
//  public PImage get(int x, int y, int w, int h);
//
//  public PImage get();
//
//  public void set(int x, int y, int c);
//
//  public void set(int x, int y, PImage src);
//
//  public void mask(int alpha[]);
//
//  public void mask(PImage alpha);
//
//  public void filter(int kind);
//
//  public void filter(int kind, float param);
//
//  public void copy(int sx, int sy, int sw, int sh, int dx, int dy, int dw,
//                   int dh);
//
//  public void copy(PImage src, int sx, int sy, int sw, int sh, int dx, int dy,
//                   int dw, int dh);
//
//  public void blend(int sx, int sy, int sw, int sh, int dx, int dy, int dw,
//                    int dh, int mode);
//
//  public void blend(PImage src, int sx, int sy, int sw, int sh, int dx, int dy,
//                    int dw, int dh, int mode);
//
////  public void beginProjection();
////
////  public void endProjection();
////
////  public void blend(int mode);
//
////  public void noBlend();
//
////  public void textureBlend(int mode);
//
////  public void noTextureBlend();
//
////  public void texture(PImage image0, PImage image1);
////
////  public void texture(PImage image0, PImage image1, PImage image2);
////
////  public void texture(PImage image0, PImage image1, PImage image2, PImage image3);
////
////  public void texture(PImage[] images);
////
////  public void vertex(float x, float y, float u0, float v0, float u1, float v1);
////
////  public void vertex(float x, float y, float u0, float v0, float u1, float v1,
////                     float u2, float v2);
////
////  public void vertex(float x, float y, float u0, float v0, float u1, float v1,
////                     float u2, float v2, float u3, float v3);
////
////  public void vertex(float x, float y, float[] u, float[] v);
////
////  public void vertex(float x, float y, float z, float u0, float v0, float u1,
////                     float v1);
////
////  public void vertex(float x, float y, float z, float u0, float v0, float u1,
////                     float v1, float u2, float v2);
////
////  public void vertex(float x, float y, float z, float u0, float v0, float u1,
////                     float v1, float u2, float v2, float u3, float v3);
////
////  public void vertex(float x, float y, float z, float[] u, float[] v);

}
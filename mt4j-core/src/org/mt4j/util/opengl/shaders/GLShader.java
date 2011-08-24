package org.mt4j.util.opengl.shaders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.mt4j.util.PlatformUtil;
import org.mt4j.util.opengl.GL20;
import processing.core.PApplet;


/** 
 * This class is used to load and apply GLSL shaders. Also will be implemented with shaderlib
 * (http://www.pixelnerve.com/processing/libraries/shaderlib/) which will support CG shaders also (you need cg toolkits installed).
 * 
 * @author Amit Kumar Sarangi
 */

public class GLShader {
	
    //private PGraphicsOpenGL pgl;
    private GL20 gl;
    
    private int glslProgram;

	int vertexShader;
	int fragmentShader;
	
	boolean vertexShaderEnabled;
	boolean vertexShaderSupported;
	
	public GLShader(PApplet pa)
	{
		//pgl = (PGraphicsOpenGL)pa.g;
		gl = PlatformUtil.getGL20();
		
		if (this.gl == null){
			System.out.println("Shaders not supported");
		}
		
		System.out.println("GLSL Version : "+gl.glGetString(GL20.GL_SHADING_LANGUAGE_VERSION));
		String extensions = gl.glGetString(GL20.GL_EXTENSIONS);
		vertexShaderSupported = extensions.indexOf("GL_ARB_vertex_shader")!=-1;
		vertexShaderEnabled = true;

		glslProgram = gl.glCreateProgram();
		
		vertexShader = -1 ;
		fragmentShader = -1 ;
	}
		
	public void loadVertexShader(String vertexShaderFileName)
	{
		String vsrc = loadShaderText(vertexShaderFileName);
		System.out.println("VertexShader : " +vertexShaderFileName);
		vertexShader = gl.glCreateShader(GL20.GL_VERTEX_SHADER);
		gl.glShaderSource(vertexShader,vsrc);
		gl.glCompileShader(vertexShader);
//		checkStatus( "(vertex) CompileStatus:", GL20.GL_COMPILE_STATUS, vertexShader );
		gl.glAttachShader(glslProgram, vertexShader);
		System.out.println("VertexShader load over");
	}

	public void loadFragmentShader(String fragmentShaderFileName)
	{
		String fsrc = loadShaderText(fragmentShaderFileName);
		System.out.println("FragmentShader : " +fragmentShaderFileName);
		fragmentShader = gl.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		gl.glShaderSource(fragmentShader,fsrc);
		gl.glCompileShader(fragmentShader);
//		checkStatus( "(fragment) CompileStatus:", GL20.GL_COMPILE_STATUS, fragmentShader );
		gl.glAttachShader(glslProgram, fragmentShader);
		System.out.println("FragmentShader load over");
	}
	
	public int getVertexShader()
	{
		return vertexShader;
	}
	
	public int getFragmentShader()
	{
		return fragmentShader;
	}
	
	public int getProgramObject()
	{
		return glslProgram;
	}
	
	public GL20 getGL()
	{
		return gl;
	}
	public int getAttribLocation(String name)
	{
	  return(gl.glGetAttribLocation(glslProgram,name));
	}

	public int getUniformLocation(String name)
	{
	  return(gl.glGetUniformLocation(glslProgram,name));
	}
	
	public void useShaders()
	{
	    gl.glLinkProgram(glslProgram);
	    gl.glValidateProgram(glslProgram);
//        checkStatus("ValidationStatus: ", GL20.GL_VALIDATE_STATUS, glslProgram );
	}
	
	public void startShader()
	{
		gl.glUseProgram(glslProgram);
	}
	
	public void stopShader()
	{
		gl.glUseProgram(0);
	}
	
	private String loadShaderText(String fileName)
	{	String text = "";	
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader shaderFile = new BufferedReader(fr);
			String line;
			while ((line=shaderFile.readLine()) != null) {
				text += line + "\n";
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Shader not found : " + fileName);
		}
		catch(IOException ex)
		{
			System.out.println("Not able to read Shader files");
		}
		
		return text;
	}
		
//    private void checkStatus( String title, int status, int obj )
//    {
//        IntBuffer iVal = BufferUtil.newIntBuffer( 1 );
//        gl.glGetParameterivARB( obj, status, iVal );
//
//        int length = iVal.get();
//        if( length < 1 ) 
//        {
//            System.err.println( "(ShaderGLSL)  Error occured with object parameter: " + length );
//            //return;
//        }
//        
//        if( status == GL20.GL_COMPILE_STATUS )
//        {
//        	if( length == 0 )
//        	{
//                System.err.println( "(ShaderGLSL)  Info Log of Shader Object ID: " + obj );
//                System.out.println("(ShaderGLSL)  --------------------------");
//        		System.err.println( "(ShaderGLSL)  There was a problem compiling the shader" );
//                System.out.println("(ShaderGLSL)  --------------------------");
//        		return;
//        	}
//        	else
//        	{
//                System.out.println( "(ShaderGLSL)  Info Log of Shader Object ID: " + obj );
//                System.out.println("(ShaderGLSL)  --------------------------");
//        		System.out.println( "(ShaderGLSL)  Shader was compiled sucessfully!" );
//                System.out.println("(ShaderGLSL)  --------------------------");
//        		return;
//        	}
//        }
//
//        ByteBuffer infoLog = BufferUtil.newByteBuffer(length);
//        iVal.flip();
//        gl.glGetInfoLogARB( obj, length, iVal, infoLog );
//        byte[] infoBytes = new byte[length];
//        infoLog.get( infoBytes );
//        System.out.println("(ShaderGLSL)  Info Log of Shader Object ID: " + obj );
//        System.out.println("(ShaderGLSL)  --------------------------");
//        System.out.println( "(ShaderGLSL)  " + title + " : " + new String(infoBytes) );
//        System.out.println("(ShaderGLSL)  --------------------------");
//    }

	  
	public void setTextureParameter( String param, int texUnit )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  	  	gl.glUniform1i( location, texUnit );
	}
	
	public void setParameter1d( String param, double x )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  	  	gl.glUniform1f( location, (float)x );
	}
	
	public void setParameter1f( String param, float x )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  		gl.glUniform1f( location, x );
	}
	
	public void setParameter1i( String param, int x )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  	  	gl.glUniform1i( location, x );				
	}
	
	public void setParameter2f( String param, float x, float y )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  	  	gl.glUniform2f( location, x, y );
	}
	
	public void setParameter3f( String param, float x, float y, float z )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  	  	gl.glUniform3f( location, x, y, z );		
	}
	
//	public void setParameter3fv( String param, float[] v )
//	{
//	  	int location = gl.glGetUniformLocation( glslProgram, param );
//  	  	gl.glUniform3fv( location, 3, v, 0 );
//	}
//	
	public void setParameter4f( String param, float x, float y, float z, float w )
	{
	  	int location = gl.glGetUniformLocation( glslProgram, param );
  	  	gl.glUniform4f( location, x, y, z, w );				
	}
	
//	public void setParameter4fv( String param, float[] v )
//	{
//	  	int location = gl.glGetUniformLocation( glslProgram, param );
//  	  	gl.glUniform4fvARB( location, 4, v, 0 );		
//	}
//	
//	public void setParameter4x4f( String param, float[] v )
//	{
//	  	int location = gl.glGetUniformLocationARB( glslProgram, param );
//  	  	gl.glUniformMatrix4fvARB( location, 16, false, v, 0 );		
//	}
	
}

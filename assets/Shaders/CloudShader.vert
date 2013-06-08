uniform vec3 eyePosition;
uniform vec3 sunDirection;
uniform float scale;
                    
varying vec2  oUv;
varying float oGlow;

void main(void)
{
   vec4 position = gl_Vertex;
  
   // get vertex-position
   gl_Position = gl_ModelViewProjectionMatrix * position;
  
   // get vertex-normal
   vec3 normal = gl_Normal;

   oGlow = pow (clamp (dot ((position.xyz - eyePosition), sunDirection), 0.0, 1.0), 7.0);
                  
   // UV-coordiantes
   oUv = vec2 (gl_MultiTexCoord0.xy) * scale;
  
}
package com.gavin.plugin.lifecycle;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @ProjectName: Demo
 * @Package: com.gavin.plugin.lifecycle
 * @ClassName: LifecycleClassVisitor
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/3/19 16:20
 * @UpdateUser: admin
 * @UpdateDate: 2019/3/19 16:20
 * @UpdateRemark:
 * @Version: 1.0
 */
public class LifecycleClassVisitor extends ClassVisitor implements Opcodes {
    /**
     * 类名
     */
    private String mClassName;


    public LifecycleClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.mClassName = name;

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access,name,desc,signature,exceptions);

        if("android/support/v4/app/FragmentActivity".equals(this.mClassName)){

            if("onCreate".equals(name)){
                System.out.println("LifecycleClassVisitor : change method ----> " + name);
                return new LifecycleOnCreateMethodVisitor(mv);
            }else if("onDestory".equals(name)){
                System.out.println("LifecycleClassVisitor : change method ----> " + name);
                return new LifecycleOnDestroyMethodVisitor(mv);
            }
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}

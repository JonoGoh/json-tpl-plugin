package dev.jonogoh

import com.intellij.codeInspection.InspectionSuppressor
import com.intellij.codeInspection.SuppressQuickFix
import com.intellij.psi.PsiElement

class JsonTplSuppressor : InspectionSuppressor {
    override fun isSuppressedFor(element: PsiElement, inspectionId: String): Boolean {
        val file = element.containingFile ?: return false
        if (!file.name.endsWith(".json.tpl")) return false
        return element.text.contains("\${")
    }

    override fun getSuppressActions(
        element: PsiElement?,
        inspectionId: String
    ): Array<SuppressQuickFix> =
        SuppressQuickFix.EMPTY_ARRAY
}
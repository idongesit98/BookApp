package com.zseni.librebook.data.mappers

import com.zseni.librebook.data.local.FormatEntity
import com.zseni.librebook.data.remoteModel.FormatsDto
import com.zseni.librebook.domain.model.Format

fun FormatsDto.toFormatEntity():FormatEntity{
    return FormatEntity(
        applicationEpubZip,
        applicationOctetStream,
        applicationPdf,
        applicationPrsTex,
        applicationRdfXml,
        applicationxmobipocketebook,
        imageJpeg,
        textHtml,
        textHtmlCharset,
        textHTMLcharset, textPlain, textplain, textplaincharset
    )
}

fun FormatEntity.toFormat(): Format {
    return Format(
        imageJpeg
    )
}